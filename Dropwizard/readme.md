#Dropwizard Framework

### Available Endpoints
This framework has the follow(ing) endpoint(s):
 * ```[GET]``` /dropwizard-hello-world?name={name}
 * ```[GET]``` /dropwizard-post-get
 * ```[POST]``` /dropwizard-post-get?name={name}

### Readme
When you run Dropwizard for the first time, it will create a server using Jetty.
When you want to run dropwizard again, a bindException may occur. To solve this problem, follow these steps:

    1. run the command "jps"
    
    2. Remember the number before "HelloWorldApplication". This is your PID
    
    3. run the command "kill -9 {PID}" (replace PID)
