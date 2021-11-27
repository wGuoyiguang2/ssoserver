1、Git init （在本地工程目录下），生成.git 文件夹

Git init

2、上传修改的文件

git add *

(*可替换成具体要上传的文件名，*表示提交所有有变化的文件) 3、添加上传文件的描述
git commit -m "test"

（”test“为分支名）
4、（创建分支）

git branch master_dev
1
5、（切换分支）

git checkout master_dev
1
6、与远程分支相关联

git remote add origin https://github.com/yangxiaoyan20/BowlingScore.git
1
（”BowlingScore“ 为工程名）
7、（将分支上传）

git push origin master_dev