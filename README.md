1、实现微信网页授权获取用户信息。
2、简单实现微信消息服务器回复各类型消息的功能框架。
3、简单实现关注微信订阅号投票的功能框架。(com.kwok.servlet.ActivityServlet.java 、 activity.jsp 、 user_a 表、 user_b 表、 record_1 表。)
4、简单实现微信网页小游戏得分和排行榜的功能框架。(com.kwok.servlet.Activity2Servlet.java 、 activity2.jsp 、 rank.jsp 、 user_a 表、 user_b 表、  record_2 表。)
5、实现微信 JS-SDK 配置信息注入。(com.kwok.servlet.WeiXinShareConfigServlet.java 、 includeShare.jsp 、 testShare.jsp 、 jweixin-1.2.0.js。)
6、包结构。
```
│  pom.xml
│  ReadMe
│
├─SQL
│      kweixin.sql
│      kweixin2.sql
│
├─src
│  ├─main
│  │  ├─java
│  │  │  └─com
│  │  │      └─kwok
│  │  │          ├─commons
│  │  │          │      EventType.java
│  │  │          │      MsgType.java
│  │  │          │      Result.java
│  │  │          │      ReturnCode.java
│  │  │          │
│  │  │          ├─config
│  │  │          │      AppConfig.java
│  │  │          │
│  │  │          ├─controller
│  │  │          │      EventController.java
│  │  │          │      TextMessageController.java
│  │  │          │
│  │  │          ├─model
│  │  │          │  │  ResXmlMsgTpl.java
│  │  │          │  │
│  │  │          │  ├─entity
│  │  │          │  │      Record2.java
│  │  │          │  │      UserA.java
│  │  │          │  │      UserB.java
│  │  │          │  │
│  │  │          │  ├─request
│  │  │          │  │      RequestEventModel.java
│  │  │          │  │      RequestImageMessageModel.java
│  │  │          │  │      RequestLinkMessageModel.java
│  │  │          │  │      RequestLocationMessageModel.java
│  │  │          │  │      RequestShortVideoMessageModel.java
│  │  │          │  │      RequestTextMessageModel.java
│  │  │          │  │      RequestVideoMessageModel.java
│  │  │          │  │      RequestVoiceMessageModel.java
│  │  │          │  │
│  │  │          │  └─response
│  │  │          │          ResponseEventModel.java
│  │  │          │          ResponseImageMessageModel.java
│  │  │          │          ResponseMusicMessageModel.java
│  │  │          │          ResponseNewsMessageModel.java
│  │  │          │          ResponseTextMessageModel.java
│  │  │          │          ResponseVideoMessageModel.java
│  │  │          │          ResponseVoiceMessageModel.java
│  │  │          │
│  │  │          ├─servlet
│  │  │          │      Activity2Servlet.java
│  │  │          │      ActivityServlet.java
│  │  │          │      MainServlet.java
│  │  │          │      OAuthCallBackServlet.java
│  │  │          │      RankServlet.java
│  │  │          │      WeiXinShareConfigServlet.java
│  │  │          │
│  │  │          └─util
│  │  │              │  CommonsUtil.java
│  │  │              │  DBUtil.java
│  │  │              │  WXUtil.java
│  │  │              │
│  │  │              └─aes
│  │  │                      AesException.java
│  │  │                      ByteGroup.java
│  │  │                      PKCS7Encoder.java
│  │  │                      SHA1.java
│  │  │                      WXBizMsgCrypt.java
│  │  │                      WXBizMsgCryptTest.java
│  │  │                      XMLParse.java
│  │  │
│  │  ├─resources
│  │  │      app.properties
│  │  │
│  │  └─webapp
│  │      │  activity.jsp
│  │      │  activity2.jsp
│  │      │  error.jsp
│  │      │  includeShare.jsp
│  │      │  index.jsp
│  │      │  rank.jsp
│  │      │  testShare.jsp
│  │      │
│  │      ├─static
│  │      │  └─js
│  │      │          jquery-1.11.3.min.js
│  │      │          jweixin-1.2.0.js
│  │      │
│  │      └─WEB-INF
│  │              web.xml
│  │
│  └─test
│      └─java
│          └─com
│              └─kwok
│                  └─test
│                          Test_URLEncode.java
│
└─target
```
