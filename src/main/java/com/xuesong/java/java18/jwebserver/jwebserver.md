JAVA18 新增 jwebserver 简易 web 服务器
我在本机执行命令就可以
```
jwebserver
```
但是我没配置好环境变量，直接找到自己的 java 的 bin 目录执行
```
/Users/buxuesong/Library/Java/JavaVirtualMachines/openjdk-19.0.1/Contents/Home/bin/jwebserver
```
会输出如下日志：
```
默认情况下绑定到环回。如果要表示所有接口，请使用 "-b 0.0.0.0" 或 "-b ::"。
为 127.0.0.1 端口 8000 上的 /Users/buxuesong/Documents/git_code/self-leecode-answer 及子目录提供服务
URL http://127.0.0.1:8000/
```
通过浏览器打开 http://127.0.0.1:8000/ 这个链接，就可看到一个非常有意思很简单的静态网站

