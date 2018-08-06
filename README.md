# SocialNetworkApplication
Social Network API

Description of the Application:
social-network-home-controller : Application to post messages and following different users.This is simple social networking application, 
similar to Twitter, whose services are exposed. The application supports the scenarios below.

1) Posting a message (Method POST- Path: /socialNetwork/postMessage)
A user will be able to post a message

2) Wall (Method GET - Path: /socialNetwork/getUserMessages)
A user will be able to see a list of the messages they've posted, in reverse chronological order.

3)Following(Method POST -Path: /socialNetwork/followUser)
A user will be able to follow another user. 

4)Timeline (Method GET - Path: /socialNetwork/getFollowingUserMessages)
A user will be able to see a list of the messages posted by all the people they follow, in reverse chronological order.

For better readability and testing of these services: Application is integrated with Swagger 2.0- http://localhost:8083/swagger-ui.html





