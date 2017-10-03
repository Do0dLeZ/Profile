package servlets;

import entity.answer.AQuestion;
import entity.answer.Answer;
import entity.question.Question;
import entity.user.User;
import session.AnswerContainer;
import session.QuestionContainer;
import session.UserSession;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("serial")
@WebServlet(name = "Profile", urlPatterns = {"/profile", "/answers"})
public class ProfileServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String saveProfile = req.getParameter("saveProfile");
        String acceptAnswers = req.getParameter("acceptAnswers");
        if (saveProfile != null) {
            setProfileData(req);
            resp.sendRedirect("profile.jsp");
        } else if (acceptAnswers != null){
            saveAnswer(req);
            resp.sendRedirect("profile.jsp");
        }
    }

    private void saveAnswer(HttpServletRequest req) {
        Answer answer = new Answer();
        User user = UserSession.getInstance().getUser();
        answer.setLogin(user.getLogin());
        for (Question question: QuestionContainer.getInstance().getQuestions()) {
            AQuestion aQuestion = new AQuestion();
            aQuestion.setId(question.getId());
            aQuestion.setValue(req.getParameter(Integer.toString(question.getId())));
            answer.getQuestions().add(aQuestion);
        }
        user.setPassedQuestionaire(true);
        UserSession.getInstance().saveUsers();
        new AnswerContainer().addAnswer(answer);
    }

    private void setProfileData(HttpServletRequest req) {
        String name = req.getParameter("user-name");
        String surname = req.getParameter("surname");
        String age = req.getParameter("age");

        UserSession.getInstance().getUser().setName(name != null ? name : "");
        UserSession.getInstance().getUser().setSurname(surname != null ? surname : "");
        UserSession.getInstance().getUser().setAge(Integer.parseInt(age));

        UserSession.getInstance().saveUsers();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
