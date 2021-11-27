1、Git init （在本地工程目录下），生成.git 文件夹

Git init

2、上传修改的文件

git add *

(*可替换成具体要上传的文件名，*表示提交所有有变化的文件) 3、添加上传文件的描述
git commit -m "master"

（”master_dev“为分支名）
4、（创建分支）

git branch master_dev
1
5、（切换分支）

git checkout master_dev
1
6、与远程分支相关联

git remote add origin https://github.com/wGuoyiguang2/ssoclient.git

git remote add origin https://github.com/wGuoyiguang2/ssoclient.git

git remote add origin https://github.com/wGuoyiguang2/myspringboot.git




1
（”ssoclient“ 为工程名）

7、（将分支上传,web 页面可见） origin 代表远程


上传之前先pull
git pull --rebase origin master

git push origin master


git push -u origin master

git push origin master_dev

git push -u origin master_dev


合并分支

在master分支上运行以下命令
1. git merge dev // 将dev分支的代码合并到master上

2. git push origin master // 将当前的更改推送到远程的master分支上

执行完以上命令，此时dev分支与master分支的代码已同步。