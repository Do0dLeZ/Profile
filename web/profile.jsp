<%@ page import="entity.question.QAnswer" %>
<%@ page import="entity.question.Question" %>
<%@ page import="entity.user.User" %>
<%@ page import="session.AnswerContainer" %>
<%@ page import="session.QuestionContainer" %>
<%@ page import="session.UserSession" %>
<html>
<head>
    <title>Profile</title>
</head>
<body>

<% User user = UserSession.getInstance().getUser();
    if (user != null) {%>
        <form name="profileForm" action="/profile" method="POST">
                Logged as (<%= user.getLogin()%>)    <a href="/login?log=exit">Logout</a><br/>
                Name:       <input type="text" name="user-name" placeholder="Enter name..." value="<%= user.getName()%>"><br/>
                Surname:    <input type="text" name="surname" placeholder="Enter surname..." value="<%= user.getSurname()%>"><br/>
                Age:        <input type="text" name="age" placeholder="Enter age..." value="<%= user.getAge()%>"><br/>
            <input type="submit" name="saveProfile" value="Save Profile Data">
        </form>
    <%}%>
    <%assert user != null;
    if (!user.isPassedQuestionaire()) {%>
        <form action="/answers" method="post">
        <%for (Question question : QuestionContainer.getInstance().getQuestions()) {%>
        <%= question.getQuestionValue()%><br/>
        <%
            for (QAnswer QAnswer : question.getQAnswers()) {%>
                <input type="radio" name="<%=question.getId()%>" id="<%= QAnswer.getId()%>" value="<%= QAnswer.getId()%>">
                <label for="<%= QAnswer.getId()%>"><%= QAnswer.getValue()%></label><br/>
            <%}%>
        <%}%>
        <input type="submit" name="acceptAnswers" value="Accept">
        </form>
    <%} else {
        AnswerContainer loader = new AnswerContainer();%>
        <%= loader.getAnswers(user.getLogin())%>
    <%}%>
</body>
</html>
