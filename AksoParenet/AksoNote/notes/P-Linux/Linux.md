# ubuntu 
ubuntu 默不支持RPM，首先sudo apt-get install rpm 
 输入你的管理员密码 
 安装完成后才能用rpm -ivh
 
 
 rpm -ivh package_name
 选项与参数：
 -i：install安装的意思
 -v：查看更详细的安装信息
 -h：显示安装进度
 
 
简单来说，Ubuntu的软件包格式是deb，如果要安装rpm的包，则要先用alien把rpm转换成deb。

sudo apt-get install alien #alien默认没有安装，所以首先要安装它

sudo alien xxxx.rpm #将rpm转换位deb，完成后会生成一个同名的xxxx.deb

sudo dpkg -i xxxx.deb #安装

注意，用alien转换的deb包并不能保证100%顺利安装，所以可以找到deb最好直接用deb

有时候，我们想要使用的软件并没有被包含到 Ubuntu 的仓库中，而程序本身也没有提供让 Ubuntu 可以使用的 deb 包，你又不愿从源代码编译。但假如软件提供有 rpm 包的话，我们也是可以在 Ubuntu 中安装的。

方法一：

1. 先安装 alien 和 fakeroot 这两个工具，其中前者可以将 rpm 包转换为 deb 包。安装命令为：

sudo apt-get install alien fakeroot

2. 将需要安装的 rpm 包下载备用，假设为 package.rpm。

3. 使用 alien 将 rpm 包转换为 deb 包：

fakeroot alien package.rpm

4. 一旦转换成功，我们可以即刻使用以下指令来安装：

sudo dpkg -i package.deb

方法二：

1.CODE:

sudo apt-get install rpm alien

2.CODE:

alien -d package.rpm

3.CODE:

sudo dpkg -i package.deb
--------------------- 
作者：暗淡亮点 
来源：CSDN 
原文：https://blog.csdn.net/suleil1/article/details/49471723 
版权声明：本文为博主原创文章，转载请附上博文链接！


/usr/bin/java/jdk1.8.0_212/bin