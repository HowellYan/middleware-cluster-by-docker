##1、k8s权限
* vi setup-helm-rbac.yaml
```
apiVersion: v1
kind: ServiceAccount
metadata:
  name: tiller
  namespace: kube-system
---
apiVersion: rbac.authorization.k8s.io/v1beta1
kind: ClusterRoleBinding
metadata:
  name: tiller
roleRef:
  apiGroup: rbac.authorization.k8s.io
  kind: ClusterRole
  name: cluster-admin
subjects:
  - kind: ServiceAccount
    name: tiller
    namespace: kube-system
```
* kubectl create -f setup-helm-rbac.yaml

##2、安装 Helm
```
sudo snap install helm --classic
```

## 3、安装 Tiller，需要‘gcr.io/kubernetes-helm/tiller’镜像
```
helm init --canary-image
```
## 4、下载“https://github.com/oracle/mysql-operator”

## 5、Installing mysql-operator
* kubectl create ns mysql-operator
* helm install --name mysql-operator mysql-operator

## 6、Delete mysql-operator
* helm delete mysql-operator