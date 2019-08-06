# Git 简介
集中式vs分布式

Linus一直痛恨的CVS及SVN都是集中式的版本控制系统，而Git是分布式版本控制系统，集中式和分布式版本控制系统有什么区别呢？

先说集中式版本控制系统，版本库是集中存放在中央服务器的，而干活的时候，用的都是自己的电脑，所以要先从中央服务器取得最新的版本，然后开始干活，干完活了，再把自己的活推送给中央服务器。中央服务器就好比是一个图书馆，你要改一本书，必须先从图书馆借出来，然后回到家自己改，改完了，再放回图书馆。

# 1. 版本的创建和回退
git add code.txt // 新建文件加入到git, 把文件添加到git 的暂存区

git commit -m 'commit comments' // 提交文件，给暂存区文件创建版本记录， 提交创建版本记录之前可以多次git add 添加文件到暂存区

git log // 查看git 记录

git reflog // 查看所有的git操作记录

git reset --hard HEAD^ 回退到前一个版本

git reset --hard HEAD 版本号 // 回退到指定的版本号

# 2. 工作区和暂存区

 git checkout file // 撤销未提交到暂存区的文件

git reset Header file // 可以把暂存区的修改撤销掉， 重新放回工作区

# 对比文件的不同

git diff HEAD -- fileName // 对比暂存区和工作区文件的不同

git diff HEAD HEAD^ -- fileName  // 对比2个不同版本文件之间的区别

rm filename // 删除文件
git rm filename // 把工作区删除的文件提交到暂存区

git log --pretty=oneline // git 以简短形式显示

git 分支管理

git把我们之前每次提交的版本串成一条时间线

git branch// 查看当前分支是哪些

git branch branchNmae // 创建分支

git checkout -b branchName //创建并切换到新的branch， branchNmae 为新的分支名称

git checkout branchNmae // 切换到branchName的分支

git merge branchName //把分支branchName上的内容合并到master上

Fast-forward // 快速合并，

## 分支冲突


git branch -d branchName // 删除branchName分支