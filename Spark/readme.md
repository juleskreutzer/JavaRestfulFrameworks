#Spark Framework

### Available Endpoints
This framework has the follow(ing) endpoint(s):
 * ```[GET]``` /spark/hello/{name}
 * ```[GET]``` /spark/post-get
 * ```[POST]``` /spark/post-get/{name}
 * ```[POST]``` /spark/stop

 ### Readme
 When you run Spark for the first time, it will create a server using Jetty.
 When you want to run Spark again, a bindException may occur. To solve this problem, follow these steps:

     1. run the command "jps"

     2. Remember the number before "HelloWorldApplication". This is your PID

     3. run the command "kill -9 {PID}" (replace PID)

 An alternative way is to call ```/spark/stop```. The server will then stop the Spark and Jetty (server) process.
