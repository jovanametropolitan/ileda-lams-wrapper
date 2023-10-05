package com.metropolitan.iledalamswrapper.lams;

import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class IledaLAMSImpl implements IledaLAMS {

    private static String LOCAL_LRS_API = "https://IP_LOCAL/data/xAPI/statements";
    private static String GLOBAL_LRS_API = "https://IP_GLOBAL/data/xAPI/statements";


    public String doPost(boolean local, String postData) throws Exception {
        doTrustToCertificates();
        PrintWriter out = null;
        BufferedReader in = null;
        StringBuilder result = new StringBuilder();

        try {
            URL realUrl = new URL(local ? LOCAL_LRS_API : GLOBAL_LRS_API);
            // build connection
            HttpsURLConnection conn = (HttpsURLConnection) realUrl.openConnection();
            // set request properties
            conn.setRequestProperty("accept", "/");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("content-type", "application/json; charset=utf-8");
            conn.setRequestProperty("X-Experience-API-Version", "1.0.3");
            byte[] message = ("KEY:PASS").getBytes("UTF-8");
            String encoded = javax.xml.bind.DatatypeConverter.printBase64Binary(message);

            conn.setRequestProperty("Authorization", "Basic " + encoded);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));

            bw.write(postData);
            bw.flush();
            bw.close();

            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result.append("/n").append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result.toString();
    }

    private void doTrustToCertificates() throws Exception {
        TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkServerTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                return;
            }

            public void checkClientTrusted(X509Certificate[] certs, String authType) throws CertificateException {
                return;
            }
        }};

        SSLContext sc = SSLContext.getInstance("SSL");
        sc.init(null, trustAllCerts, new SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HostnameVerifier hv = new HostnameVerifier() {
            public boolean verify(String urlHostName, SSLSession session) {
                if (!urlHostName.equalsIgnoreCase(session.getPeerHost())) {
                    System.out.println("Warning: URL host '" + urlHostName + "' is different to SSLSession host '" + session.getPeerHost() + "'.");
                }
                return true;
            }
        };
        HttpsURLConnection.setDefaultHostnameVerifier(hv);
    }

//
//    private void statementLogin(boolean local) throws IOException {
//
//        SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        Predmet cs120 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("id", 1042l)).uniqueResult();
//        Predmet it131 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("sifra", "IT131")).uniqueResult();
//        List<Overa> overaList = genericDao.getSession().createCriteria(Overa.class).add(Restrictions.or(Restrictions.eq("predmetId", cs120), Restrictions.eq("predmetId", it131))).createCriteria("upisId").add(Restrictions.eq("skolskaGodinaId", SkolskaGodinaUtil.getInstance().trenutnaSkolskaGodina(genericDao.getSession()))).list();
//
//        Set<Student> studentList = new HashSet<>();
//
//        for (Overa overa : overaList) {
//            studentList.add(overa.getUpisId().getStudentId());
//        }
//        for (Student student : studentList) {
//            IsumUser user = student.getIsumUserId();
//
//            System.out.println(user.getUsername());
//            String sql = "select occurred_date_time, lo2.name from lams_organisation lo1 " + "join lams_organisation lo2 on lo2.parent_organisation_id = lo1.organisation_id " + "join lams_lesson ll on lo2.organisation_id = ll.organisation_id " + "join lams_log_event lle on ll.lesson_id = lle.lesson_id " + "join lams_user lu on lle.user_id = lu.user_id " + "where  (lo1.name like 'IT131%' OR lo1.name like 'CS120%') " + "and login like '" + user.getUsername() + "' " + "order by occurred_date_time asc;";
//
//            try {
//                ResultSet rs = lamsConnection.getStmt().executeQuery(sql);
//                Date previousDateTime = new Date(946681200000L);
//                boolean isFirst = true;
//                while (rs.next()) {
//
//
//                    IledaStatement statement = new IledaStatement();
//
//                    IledaActor actor = new IledaActor(user.getUsername(), "mailto:" + user.getMail());
//
//                    IledaDisplay display = new IledaDisplay("logged into");
//                    IledaVerb verb = new IledaVerb(display, IledaVerbType.LOGGED_IN);
//                    statement.setActor(actor);
//                    statement.setVerb(verb);
//
//                    String dateStr = rs.getString("occurred_date_time");
//                    Date date = sdfSource.parse(dateStr);
//
//                    statement.setTimestamp(sdfDestination.format(date));
//
//
//                    if (date.getTime() - previousDateTime.getTime() >= 3600000) {
//                        // LOGIN
//
//                        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//                        String json = ow.writeValueAsString(statement);
//                        doPost(local, json);
//
//                        if (!isFirst) {
//                            //LOGOUT
//                            statement.getVerb().setDisplay(new IledaDisplay("logged out of"));
//                            statement.getVerb().setId(IledaVerbType.LOGGED_OUT);
//                            previousDateTime.setTime(previousDateTime.getTime() + 3600000);
//                            statement.setTimestamp(sdfDestination.format(previousDateTime));
//                            System.out.println("LOGOUT " + statement.getTimestamp());
//                            ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//                            json = ow.writeValueAsString(statement);
//                            doPost(local, json);
//                        } else {
//                            isFirst = false;
//                        }
//
//                        System.out.println("LOGIN " + sdfDestination.format(date));
//                    }
//                    previousDateTime = date;
//
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        closeConnection();
//    }
//
//    private void statementSubmissionUploadedAndCompleted(boolean local) throws IOException {
//        // The student uploads the practice
//        openConnectionLamsMet();
//        SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        Predmet cs120 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("id", 1042l)).uniqueResult();
//        Predmet it131 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("sifra", "IT131")).uniqueResult();
//        List<Overa> overaList = genericDao.getSession().createCriteria(Overa.class).add(Restrictions.or(Restrictions.eq("predmetId", cs120), Restrictions.eq("predmetId", it131))).createCriteria("upisId").add(Restrictions.eq("skolskaGodinaId", SkolskaGodinaUtil.getInstance().trenutnaSkolskaGodina(genericDao.getSession()))).list();
//
//        Set<Student> studentList = new HashSet<>();
//
//        for (Overa overa : overaList) {
//            studentList.add(overa.getUpisId().getStudentId());
//        }
//        for (Student student : studentList) {
//            IsumUser user = student.getIsumUserId();
//
//            String sql = "select  lld.original_learning_design_id as definition_type, DATE_ADD(lld.create_date_time, INTERVAL 8 DAY) as due_date, lld.title as name_en, " + "login_name, lla.title, tl11sd.date_of_submission, lo1.name " + "from lams_organisation lo1 " + "join lams_organisation lo2 on lo1.organisation_id = lo2.parent_organisation_id " + "join lams_lesson ll on lo2.organisation_id = ll.organisation_id " + "join lams_learning_design lld on ll.learning_design_id = lld.learning_design_id " + "join lams_learning_activity lla on lld.learning_design_id = lla.learning_design_id " + "join tl_lasbmt11_session session on session.content_id = lla.tool_content_id " + "join tl_lasbmt11_submission_details tl11sd on session.session_id = tl11sd.session_id " + "join tl_lasbmt11_report report on tl11sd.submission_id = report.report_id " + "join tl_lasbmt11_user tl11u on tl11sd.learner_id = tl11u.uid " + "where lla.tool_id = 18 and (lo1.name like 'IT131%' or lo1.name like 'CS120%') and login_name like '" + user.getUsername() + "' ;";
//
//            try {
//                ResultSet rs = lamsConnection.getStmt().executeQuery(sql);
//                while (rs.next()) {
//                    SubmissionIledaStatement statement = new SubmissionIledaStatement();
//
//                    SubmissionIledaActor actor = new SubmissionIledaActor(user.getUsername(), "mailto:" + user.getMail());
//
//                    SubmissionIledaDisplay display = new SubmissionIledaDisplay("completed");
//                    SubmissionIledaVerb verb = new SubmissionIledaVerb(display, IledaVerbType.SUBMISSION_COMPLETED);
//                    statement.setActor(actor);
//                    statement.setVerb(verb);
//
//                    String dateStr = rs.getString("date_of_submission");
//                    Date date = sdfSource.parse(dateStr);
//
//                    statement.setTimestamp(sdfDestination.format(date));
//                    statement.getContext().getContextActivities().getGrouping().get(1).setId("http://lams.metropolitan.ac.rs:8080/course=" + rs.getString("name").split(" ")[0]);
//                    statement.getContext().getContextActivities().getGrouping().get(1).getDefinition().getName().setEn(rs.getString("name").split(" ")[0]);
//
//
//                    statement.getObject().setId("http://lams.metropolitan.ac.rs:8080/submissionId=" + rs.getString("definition_type"));
//                    String dueDateStr = rs.getString("due_date");
//                    Date dueDate = sdfSource.parse(dueDateStr);
//                    statement.getObject().getDefinition().getExtensions().put("http://xapi.jisc.ac.uk/dueDate", dueDate.getTime() + "");
//                    String nameEn = new String(rs.getBytes("name_en"), StandardCharsets.UTF_8);
//                    statement.getObject().getDefinition().getName().setEn(nameEn);
//
//                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//                    String json = ow.writeValueAsString(statement);
//                    doPost(local, json);
//
//                    // The student, once the practice has been uploaded, marks the practice as completed automatically.
//                    // dupliramo isti sa izmenom definition type-a
//
//                    statement.getObject().getDefinition().setType("http://id.tincanapi.com/activitytype/lms/module");
//                    statement.getObject().getDefinition().setExtensions(new HashMap<String, String>());
//                    statement.getObject().getDefinition().getExtensions().put("https://w3id.org/learning-analytics/learning-management-system/external-id", "");
//
//
//                    ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//                    json = ow.writeValueAsString(statement);
//                    doPost(local, json);
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        closeConnection();
//    }
//
//
//    private void statementSubmissionGraded(boolean local) throws IOException {
//        openConnectionLamsMet();
//        SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        Predmet cs120 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("id", 1042l)).uniqueResult();
//        Predmet it131 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("sifra", "IT131")).uniqueResult();
//        List<Overa> overaList = genericDao.getSession().createCriteria(Overa.class).add(Restrictions.or(Restrictions.eq("predmetId", cs120), Restrictions.eq("predmetId", it131))).createCriteria("upisId").add(Restrictions.eq("skolskaGodinaId", SkolskaGodinaUtil.getInstance().trenutnaSkolskaGodina(genericDao.getSession()))).list();
//
//        Set<Student> studentList = new HashSet<>();
//
//        for (Overa overa : overaList) {
//            studentList.add(overa.getUpisId().getStudentId());
//        }
//        for (Student student : studentList) {
//            IsumUser user = student.getIsumUserId();
//
//            String sql = "select  lld.original_learning_design_id as definition_type, DATE_ADD(lld.create_date_time, INTERVAL 8 DAY) as due_date, lld.title as name_en, " + "login_name, lla.title, tl11sd.date_of_submission, lo1.name, report.date_marks_released as marks_date_released, report.marks, report.comments as comment " + "from lams_organisation lo1 " + "join lams_organisation lo2 on lo1.organisation_id = lo2.parent_organisation_id " + "join lams_lesson ll on lo2.organisation_id = ll.organisation_id " + "join lams_learning_design lld on ll.learning_design_id = lld.learning_design_id " + "join lams_learning_activity lla on lld.learning_design_id = lla.learning_design_id " + "join tl_lasbmt11_session session on session.content_id = lla.tool_content_id " + "join tl_lasbmt11_submission_details tl11sd on session.session_id = tl11sd.session_id " + "join tl_lasbmt11_report report on tl11sd.submission_id = report.report_id " + "join tl_lasbmt11_user tl11u on tl11sd.learner_id = tl11u.uid " + "where lla.tool_id = 18 and (lo1.name like 'IT131%' or lo1.name like 'CS120%') and login_name like '" + user.getUsername() + "' ;";
//            String json = "";
//            try {
//                ResultSet rs = lamsConnection.getStmt().executeQuery(sql);
//                while (rs.next()) {
//                    SubmissionGradedIledaStatement statement = new SubmissionGradedIledaStatement();
//                    statement.getResult().getScore().setRaw(rs.getDouble("marks"));
//                    if (statement.getResult().getScore().getRaw() < 5) statement.getResult().getScore().setRaw(5);
//                    statement.getResult().getScore().setMin(5);
//                    statement.getResult().getScore().setMax(10);
//                    double x = rs.getDouble("marks");
//                    if (x > 0) {
//                        statement.getResult().getScore().setScaled((x - 5) / 5);
//                    } else {
//                        statement.getResult().getScore().setScaled(0.0);
//                        statement.getResult().setSuccess(false);
//                        statement.getResult().setCompletion(false);
//                    }
//                    statement.getResult().setResponse(rs.getString("comment") == null ? "/" : rs.getString("comment"));
//                    SubmissionGradedIledaActor actor = new SubmissionGradedIledaActor(user.getUsername(), "mailto:" + user.getMail());
//
//                    SubmissionGradedIledaDisplay display = new SubmissionGradedIledaDisplay("attained grade for");
//                    SubmissionGradedIledaVerb verb = new SubmissionGradedIledaVerb(display, IledaVerbType.SUBMISSION_SCORED);
//                    statement.setActor(actor);
//                    statement.setVerb(verb);
//
//                    String dateStr = rs.getString("marks_date_released");
//                    if (dateStr == null) {
//                        continue;
//                    }
//                    Date date = sdfSource.parse(dateStr);
//
//                    statement.setTimestamp(sdfDestination.format(date));
//                    statement.getContext().getContextActivities().getGrouping().get(1).setId("http://lams.metropolitan.ac.rs:8080/course=" + rs.getString("name").split(" ")[0]);
//                    statement.getContext().getContextActivities().getGrouping().get(1).getDefinition().getName().setEn(rs.getString("name").split(" ")[0]);
//
//
//                    statement.getContext().getInstructor().setName("lams");
//                    statement.getContext().getInstructor().setMbox("mailto:lams@metropolitan.ac.rs");
//
//                    statement.getObject().setId("http://lams.metropolitan.ac.rs:8080/submissionId=" + rs.getString("definition_type"));
//                    String dueDateStr = rs.getString("due_date");
//                    Date dueDate = sdfSource.parse(dueDateStr);
//                    statement.getObject().getDefinition().getExtensions().put("http://xapi.jisc.ac.uk/dueDate", dueDate.getTime() + "");
//                    String nameEn = new String(rs.getBytes("name_en"), StandardCharsets.UTF_8);
//                    statement.getObject().getDefinition().getName().setEn(nameEn);
//
//                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//                    json = ow.writeValueAsString(statement);
//                    System.out.println(json);
//                    doPost(local, json);
//
//                }
//            } catch (Exception e) {
//
//                e.printStackTrace();
//            }
//        }
//
//        closeConnection();
//    }
//
//    private void statementExamEntered(boolean local) throws IOException {
//        openConnectionLamsMet();
//        SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        Predmet cs120 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("id", 1042l)).uniqueResult();
//        Predmet it131 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("sifra", "IT131")).uniqueResult();
//        List<Overa> overaList = genericDao.getSession().createCriteria(Overa.class).add(Restrictions.or(Restrictions.eq("predmetId", cs120), Restrictions.eq("predmetId", it131))).createCriteria("upisId").add(Restrictions.eq("skolskaGodinaId", SkolskaGodinaUtil.getInstance().trenutnaSkolskaGodina(genericDao.getSession()))).list();
//
//        Set<Student> studentList = new HashSet<>();
//
//        for (Overa overa : overaList) {
//            studentList.add(overa.getUpisId().getStudentId());
//        }
//        for (Student student : studentList) {
//            IsumUser user = student.getIsumUserId();
//
//            String sql = "select login_name, start_date, title, r.assessment_uid as assessment_id " + "from tl_laasse10_assessment_result r " + "join tl_laasse10_assessment a on r.assessment_uid = a.uid " + "join tl_laasse10_user u on r.user_uid = u.uid " + "where (title like '%IT131%' or title like '%CS120%') and login_name like '" + user.getUsername() + "' ;";
//
//            try {
//                ResultSet rs = lamsConnection.getStmt().executeQuery(sql);
//                while (rs.next()) {
//                    ExamEnteredIledaStatement statement = new ExamEnteredIledaStatement();
//
//                    ExamEnteredIledaActor actor = new ExamEnteredIledaActor(user.getUsername(), "mailto:" + user.getMail());
//
//                    ExamEnteredIledaDisplay display = new ExamEnteredIledaDisplay("viewed");
//                    ExamEnteredIledaVerb verb = new ExamEnteredIledaVerb(display, IledaVerbType.EXAM_ENTERED);
//                    statement.setActor(actor);
//                    statement.setVerb(verb);
//
//                    String dateStr = rs.getString("start_date");
//                    Date date = sdfSource.parse(dateStr);
//
//                    statement.setTimestamp(sdfDestination.format(date));
//                    statement.getContext().getContextActivities().getGrouping().get(1).setId("http://lams.metropolitan.ac.rs:8080/course=" + rs.getString("title").split("-")[0]);
//                    statement.getContext().getContextActivities().getGrouping().get(1).getDefinition().getName().setEn(rs.getString("title").split("-")[0]);
//
//                    statement.getObject().setId("http://lams.metropolitan.ac.rs:8080/quizId= " + rs.getInt("assessment_id"));
//
//                    statement.getObject().getDefinition().getExtensions().put("https://w3id.org/learning-analytics/learning-management-system/external-id", "");
//                    String nameEn = new String(rs.getBytes("title"), StandardCharsets.UTF_8);
//                    statement.getObject().getDefinition().getName().setEn(nameEn);
//
//                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//                    String json = ow.writeValueAsString(statement);
//                    doPost(local, json);
//
//
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        closeConnection();
//    }
//
//    private void statementExamStarted(boolean local) throws IOException {
//        openConnectionLamsMet();
//        SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        Predmet cs120 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("id", 1042l)).uniqueResult();
//        Predmet it131 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("sifra", "IT131")).uniqueResult();
//        List<Overa> overaList = genericDao.getSession().createCriteria(Overa.class).add(Restrictions.or(Restrictions.eq("predmetId", cs120), Restrictions.eq("predmetId", it131))).createCriteria("upisId").add(Restrictions.eq("skolskaGodinaId", SkolskaGodinaUtil.getInstance().trenutnaSkolskaGodina(genericDao.getSession()))).list();
//
//        Set<Student> studentList = new HashSet<>();
//
//        for (Overa overa : overaList) {
//            studentList.add(overa.getUpisId().getStudentId());
//        }
//        for (Student student : studentList) {
//            IsumUser user = student.getIsumUserId();
//
//            String sql = "select login_name, time_limit_launched_date as started_date, title, r.assessment_uid as assessment_id " + "from tl_laasse10_assessment_result r " + "join tl_laasse10_assessment a on r.assessment_uid = a.uid " + "join tl_laasse10_user u on r.user_uid = u.uid " + "where (title like '%IT131%' or title like '%CS120%') and login_name like '" + user.getUsername() + "' and time_limit_launched_date is not null;";
//
//            try {
//                ResultSet rs = lamsConnection.getStmt().executeQuery(sql);
//                while (rs.next()) {
//                    ExamStartedIledaStatement statement = new ExamStartedIledaStatement();
//
//                    ExamStartedIledaActor actor = new ExamStartedIledaActor(user.getUsername(), "mailto:" + user.getMail());
//
//                    ExamStartedIledaDisplay display = new ExamStartedIledaDisplay("started");
//                    ExamStartedIledaVerb verb = new ExamStartedIledaVerb(display, IledaVerbType.EXAM_START);
//                    statement.setActor(actor);
//                    statement.setVerb(verb);
//
//                    String dateStr = rs.getString("started_date");
//                    Date date = sdfSource.parse(dateStr);
//
//                    statement.setTimestamp(sdfDestination.format(date));
//                    statement.getContext().getContextActivities().getGrouping().get(1).setId("http://lams.metropolitan.ac.rs:8080/course=" + rs.getString("title").split("-")[0]);
//                    statement.getContext().getContextActivities().getGrouping().get(1).getDefinition().getName().setEn(rs.getString("title").split("-")[0]);
//                    statement.getContext().getContextActivities().getOther().get(0).setId("http://lams.metropolitan.ac.rs:8080/attempt=7&cmid=" + rs.getInt("assessment_id"));
//
//                    statement.getObject().setId("http://lams.metropolitan.ac.rs:8080/quizId= " + rs.getInt("assessment_id"));
//
//                    statement.getObject().getDefinition().getExtensions().put("https://w3id.org/learning-analytics/learning-management-system/external-id", "");
//                    String nameEn = new String(rs.getBytes("title"), StandardCharsets.UTF_8);
//                    statement.getObject().getDefinition().getName().setEn(nameEn);
//
//                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//                    String json = ow.writeValueAsString(statement);
//                    doPost(local, json);
//
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        closeConnection();
//    }
//
//    private void statementExamReceived(boolean local) throws IOException {
//
//        openConnectionLamsMet();
//        SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        Predmet cs120 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("id", 1042l)).uniqueResult();
//        Predmet it131 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("sifra", "IT131")).uniqueResult();
//        List<Overa> overaList = genericDao.getSession().createCriteria(Overa.class).add(Restrictions.or(Restrictions.eq("predmetId", cs120), Restrictions.eq("predmetId", it131))).createCriteria("upisId").add(Restrictions.eq("skolskaGodinaId", SkolskaGodinaUtil.getInstance().trenutnaSkolskaGodina(genericDao.getSession()))).list();
//
//        Set<Student> studentList = new HashSet<>();
//
//        for (Overa overa : overaList) {
//            studentList.add(overa.getUpisId().getStudentId());
//        }
//        for (Student student : studentList) {
//            IsumUser user = student.getIsumUserId();
//
//            String sql = "select login_name, time_limit_launched_date as started_date, title, r.assessment_uid as assessment_id " + "from tl_laasse10_assessment_result r " + "join tl_laasse10_assessment a on r.assessment_uid = a.uid " + "join tl_laasse10_user u on r.user_uid = u.uid " + "where (title like '%IT131%' or title like '%CS120%') and login_name like '" + user.getUsername() + "' and time_limit_launched_date is not null;";
//
//            try {
//                ResultSet rs = lamsConnection.getStmt().executeQuery(sql);
//                while (rs.next()) {
//                    ExamReceivedIledaStatement statement = new ExamReceivedIledaStatement();
//
//                    ExamReceivedIledaActor actor = new ExamReceivedIledaActor(user.getUsername(), "mailto:" + user.getMail());
//
//                    ExamReceivedIledaDisplay display = new ExamReceivedIledaDisplay("received");
//                    ExamReceivedIledaVerb verb = new ExamReceivedIledaVerb(display, IledaVerbType.EXAM_RECEIVED);
//                    statement.setActor(actor);
//                    statement.setVerb(verb);
//
//                    String dateStr = rs.getString("started_date");
//                    Date date = sdfSource.parse(dateStr);
//
//                    statement.setTimestamp(sdfDestination.format(date));
//                    statement.getContext().getContextActivities().getGrouping().get(1).setId("http://lams.metropolitan.ac.rs:8080/course=" + rs.getString("title").split("-")[0]);
//                    statement.getContext().getContextActivities().getGrouping().get(1).getDefinition().getName().setEn(rs.getString("title").split("-")[0]);
//
//                    ExamReceivedIledaGroupingDefinitionWithExtensions singleExt = new ExamReceivedIledaGroupingDefinitionWithExtensions("http://xapi.jisc.ac.uk/activities/quiz", new ExamReceivedIledaGroupingDefinitionName(rs.getString("title")));
//                    singleExt.setExtensions(new HashMap<String, String>());
//                    singleExt.getExtensions().put("https://w3id.org/learning-analytics/learning-management-system/external-id", "");
//
//
//                    statement.getContext().getContextActivities().getGrouping().add(new ExamReceivedIledaGrouping("http://lams.metropolitan.ac.rs:8080/quizId= " + rs.getInt("assessment_id"), singleExt));
//
//                    statement.getContext().getContextActivities().getGrouping().add(new ExamReceivedIledaGrouping("http://lams.metropolitan.ac.rs:8080/quiz/attempt?attempt=1&cmid=" + rs.getInt("assessment_id"), new ExamReceivedIledaGroupingDefinition("http://adlnet.gov/expapi/activities/attempt", new ExamReceivedIledaGroupingDefinitionName("Attempt"))));
//
//                    statement.getObject().setId("http://lams.metropolitan.ac.rs:8080/quizId= " + rs.getInt("assessment_id"));
//
//                    statement.getObject().getDefinition().getExtensions().put("https://w3id.org/learning-analytics/learning-management-system/external-id", "");
//                    String nameEn = new String(rs.getBytes("title"), StandardCharsets.UTF_8);
//                    statement.getObject().getDefinition().getName().setEn(nameEn);
//
//                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//                    String json = ow.writeValueAsString(statement);
//                    doPost(local, json);
//
//
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        closeConnection();
//    }
//
//    private void statementQuestionTrueFalse(boolean local) throws IOException {
//
//        openConnectionLamsMet();
//        SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        Predmet cs120 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("id", 1042l)).uniqueResult();
//        Predmet it131 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("sifra", "IT131")).uniqueResult();
//        List<Overa> overaList = genericDao.getSession().createCriteria(Overa.class).add(Restrictions.or(Restrictions.eq("predmetId", cs120), Restrictions.eq("predmetId", it131))).createCriteria("upisId").add(Restrictions.eq("skolskaGodinaId", SkolskaGodinaUtil.getInstance().trenutnaSkolskaGodina(genericDao.getSession()))).list();
//
//        Set<Student> studentList = new HashSet<>();
//
//        for (Overa overa : overaList) {
//            studentList.add(overa.getUpisId().getStudentId());
//        }
//        for (Student student : studentList) {
//            IsumUser user = student.getIsumUserId();
//
//            String sql = "select  a.uid as assessment_id, q.uid, a.title as a_title, q.title as q_title, correct_answer, answer_boolean, mark, r.finish_date, login_name " + "from tl_laasse10_assessment a " + "         join tl_laasse10_assessment_question q on a.uid = q.assessment_uid " + "         join tl_laasse10_question_result r on q.uid = r.assessment_question_uid " + "        join tl_laasse10_assessment_result ar on ar.uid = r.result_uid " + "         join tl_laasse10_user u on ar.user_uid = u.uid " + "where (a.title like '%IT131%' or a.title like '%CS120%') " + "  and question_type = 5 " + "  and r.finish_date is not null and login_name like '" + user.getUsername() + "';";
//
//            try {
//                ResultSet rs = lamsConnection.getStmt().executeQuery(sql);
//                while (rs.next()) {
//                    QuestionIledaStatement statement = new QuestionIledaStatement();
//
//                    QuestionIledaActor actor = new QuestionIledaActor(user.getUsername(), "mailto:" + user.getMail());
//
//                    QuestionIledaDisplay display = new QuestionIledaDisplay("answered");
//                    QuestionIledaVerb verb = new QuestionIledaVerb(display, IledaVerbType.ANSWERED);
//                    statement.setActor(actor);
//                    statement.setVerb(verb);
//
//                    String dateStr = rs.getString("finish_date");
//                    Date date = sdfSource.parse(dateStr);
//
//                    statement.setTimestamp(sdfDestination.format(date));
//                    statement.getContext().getContextActivities().getGrouping().get(1).setId("http://lams.metropolitan.ac.rs:8080/course=" + rs.getString("a_title").split("-")[0]);
//                    statement.getContext().getContextActivities().getGrouping().get(1).getDefinition().getName().setEn(rs.getString("a_title").split("-")[0]);
//
//                    QuestionResult res = new QuestionResult();
//                    res.setResponse(rs.getBoolean("answer_boolean") ? "False" : "True"); // odgovor studenta This field represents the learner's response to the question.
//                    res.setCompletion(true); // uradio / nije This field indicates whether the question has been completed or answered.
//                    res.setSuccess(rs.getBoolean("mark")); // This field indicates whether the learner's answer is considered successful or correct.
//                    res.setExtensions(new HashMap<String, Boolean>());
//                    res.getExtensions().put("http://learninglocker.net/xapi/cmi/true-false/response", rs.getBoolean("answer_boolean"));
//                    statement.setResult(res);
//
//                    QuestionIledaGroupingDefinitionWithExtensions singleExt = new QuestionIledaGroupingDefinitionWithExtensions("http://xapi.jisc.ac.uk/activities/quiz", new QuestionIledaGroupingDefinitionName(rs.getString("q_title")));
//                    singleExt.setExtensions(new HashMap<String, String>());
//                    singleExt.getExtensions().put("https://w3id.org/learning-analytics/learning-management-system/external-id", "");
//
//
//                    statement.getContext().getContextActivities().getGrouping().add(new QuestionIledaGrouping("http://lams.metropolitan.ac.rs:8080/quizId= " + rs.getInt("assessment_id"), singleExt));
//
//                    statement.getContext().getContextActivities().getGrouping().add(new QuestionIledaGrouping("http://lams.metropolitan.ac.rs:8080/quiz/attempt?attempt=1&cmid=" + rs.getInt("assessment_id") + "&q_id=" + rs.getInt("uid"), new QuestionIledaGroupingDefinition("http://adlnet.gov/expapi/activities/attempt", new QuestionIledaGroupingDefinitionName("Attempt"))));
//
//                    statement.getObject().setId("http://lams.metropolitan.ac.rs:8080/quizId= " + rs.getInt("assessment_id"));
//
//                    statement.getObject().getDefinition().setInteractionType("true-false");
//                    String nameEnSub = new String(rs.getBytes("a_title"), StandardCharsets.UTF_8);
//                    String nameEn = new String(rs.getBytes("q_title"), StandardCharsets.UTF_8);
//                    statement.getObject().getDefinition().getName().setEn(nameEnSub + "-" + nameEn);
//
//                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//                    String json = ow.writeValueAsString(statement);
//                    // System.out.println(json);
//                    doPost(local, json);
//
//
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        closeConnection();
//    }
//
//    private void statementQuestionMultiple(boolean local) throws IOException {
//
//        openConnectionLamsMet();
//        SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        Predmet cs120 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("id", 1042l)).uniqueResult();
//        Predmet it131 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("sifra", "IT131")).uniqueResult();
//        List<Overa> overaList = genericDao.getSession().createCriteria(Overa.class).add(Restrictions.or(Restrictions.eq("predmetId", cs120), Restrictions.eq("predmetId", it131))).createCriteria("upisId").add(Restrictions.eq("skolskaGodinaId", SkolskaGodinaUtil.getInstance().trenutnaSkolskaGodina(genericDao.getSession()))).list();
//
//        Set<Student> studentList = new HashSet<>();
//
//        for (Overa overa : overaList) {
//            studentList.add(overa.getUpisId().getStudentId());
//
//
//        }
//
//        String sql1 = "select distinct  a.title " + "from tl_laasse10_assessment a " + "         join tl_laasse10_assessment_question q on a.uid = q.assessment_uid " + "         join tl_laasse10_assessment_result r on a.uid = r.assessment_uid " + "         join tl_laasse10_question_result qr on r.uid = qr.result_uid and q.uid = qr.assessment_question_uid " + "         join tl_laasse10_option_answer oa on qr.uid = oa.question_result_uid " + "         join tl_laasse10_question_option o on q.uid = o.question_uid and oa.question_option_uid = o.uid " + "         join tl_laasse10_user u on r.user_uid = u.uid " + "where (a.title like '%IT131%' or a.title like '%CS120%')  and question_type = 1 ;";
//        List<String> testovi = new ArrayList<>();
//
//        try {
//            ResultSet rs1 = lamsConnection.getStmt().executeQuery(sql1);
//            while (rs1.next()) {
//
//                testovi.add(rs1.getString("title"));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//
//        for (String test : testovi) {
//            List<String> pitanja = new ArrayList<>();
//            try {
//
//
//                String sql2 = " select distinct q.title  " + "from tl_laasse10_assessment a " + "         join tl_laasse10_assessment_question q on a.uid = q.assessment_uid " + "         join tl_laasse10_assessment_result r on a.uid = r.assessment_uid " + "         join tl_laasse10_question_result qr on r.uid = qr.result_uid and q.uid = qr.assessment_question_uid " + "         join tl_laasse10_option_answer oa on qr.uid = oa.question_result_uid " + "         join tl_laasse10_question_option o on q.uid = o.question_uid and oa.question_option_uid = o.uid " + "         join tl_laasse10_user u on r.user_uid = u.uid " + "where (a.title like '%IT131%' or a.title like '%CS120%')  and question_type = 1  and a.title like '" + test + "'";
//                ResultSet rs2 = lamsConnection.getStmt().executeQuery(sql2);
//                while (rs2.next()) {
//                    pitanja.add(rs2.getString("title"));
//                }
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//            for (String pitanje : pitanja) {
//
//                for (Student student : studentList) {
//                    IsumUser user = student.getIsumUserId();
//
//                    String sql = "select a.title as a_title, q.title as q_title,  q.uid, a.uid as assessment_id,  r.user_uid, qr.mark, oa.answer_boolean, o.grade, qr.finish_date, login_name, o.option_string " + "from tl_laasse10_assessment a " + "         join tl_laasse10_assessment_question q on a.uid = q.assessment_uid " + "         join tl_laasse10_assessment_result r on a.uid = r.assessment_uid " + "         join tl_laasse10_question_result qr on r.uid = qr.result_uid and q.uid = qr.assessment_question_uid " + "         join tl_laasse10_option_answer oa on qr.uid = oa.question_result_uid " + "         join tl_laasse10_question_option o on q.uid = o.question_uid and oa.question_option_uid = o.uid " + "         join tl_laasse10_user u on r.user_uid = u.uid " + "where (a.title like '%IT131%' or a.title like '%CS120%') and oa.answer_boolean =1  and question_type = 1  and q.title like '" + pitanje + "' and login_name like '" + user.getUsername() + "' and a.title like '" + test + "'";
//
//                    try {
//                        ResultSet rs = lamsConnection.getStmt().executeQuery(sql);
//                        List<String> options = new ArrayList<>();
//
//                        String json = null;
//                        while (rs.next()) {
//                            QuestionMultipleIledaStatement statement = new QuestionMultipleIledaStatement();
//                            options.add(rs.getString("option_string"));
//
//
//                            QuestionMultipleIledaActor actor = new QuestionMultipleIledaActor(user.getUsername(), "mailto:" + user.getMail());
//
//                            QuestionMultipleIledaDisplay display = new QuestionMultipleIledaDisplay("answered");
//                            QuestionMultipleIledaVerb verb = new QuestionMultipleIledaVerb(display, IledaVerbType.ANSWERED);
//                            statement.setActor(actor);
//                            statement.setVerb(verb);
//
//                            String dateStr = rs.getString("finish_date");
//                            Date date = sdfSource.parse(dateStr != null ? dateStr : new Date().toString());
//
//                            statement.setTimestamp(sdfDestination.format(date));
//                            statement.getContext().getContextActivities().getGrouping().get(1).setId("http://lams.metropolitan.ac.rs:8080/course=" + rs.getString("a_title").split("-")[0]);
//                            statement.getContext().getContextActivities().getGrouping().get(1).getDefinition().getName().setEn(rs.getString("a_title").split("-")[0]);
//
//                            QuestionMultipleResult res = new QuestionMultipleResult();
//                            String[] arr = new String[options.size()];
//                            options.toArray(arr);
//                            res.getScore().setScaled(rs.getDouble("mark"));
//                            res.setResponse(options.toString()); // odgovor studenta This field represents the learner's response to the QuestionMultiple.
//                            res.setCompletion(true); // uradio / nije This field indicates whether the QuestionMultiple has been completed or answered.
//                            res.setSuccess(rs.getBoolean("mark")); // This field indicates whether the learner's answer is considered successful or correct.
//                            res.setExtensions(new HashMap<String, Boolean>());
//                            res.getExtensions().put("http://learninglocker.net/xapi/cmi/true-false/response", rs.getBoolean("answer_boolean"));
//                            statement.setResult(res);
//
//                            QuestionMultipleIledaGroupingDefinitionWithExtensions singleExt = new QuestionMultipleIledaGroupingDefinitionWithExtensions("http://xapi.jisc.ac.uk/activities/quiz", new QuestionMultipleIledaGroupingDefinitionName(rs.getString("q_title")));
//                            singleExt.setExtensions(new HashMap<String, String>());
//                            singleExt.getExtensions().put("https://w3id.org/learning-analytics/learning-management-system/external-id", "");
//
//
//                            statement.getContext().getContextActivities().getGrouping().add(new QuestionMultipleIledaGrouping("http://lams.metropolitan.ac.rs:8080/quizId= " + rs.getInt("assessment_id"), singleExt));
//
//                            statement.getContext().getContextActivities().getGrouping().add(new QuestionMultipleIledaGrouping("http://lams.metropolitan.ac.rs:8080/quiz/attempt?attempt=1&cmid=" + rs.getInt("assessment_id") + "&q_id=" + rs.getInt("uid"), new QuestionMultipleIledaGroupingDefinition("http://adlnet.gov/expapi/activities/attempt", new QuestionMultipleIledaGroupingDefinitionName("Attempt"))));
//
//                            statement.getObject().setId("http://lams.metropolitan.ac.rs:8080/quizId= " + rs.getInt("assessment_id"));
//
//                            statement.getObject().getDefinition().setInteractionType("choice");
//                            String nameEnSub = new String(rs.getBytes("a_title"), StandardCharsets.UTF_8);
//                            String nameEn = new String(rs.getBytes("q_title"), StandardCharsets.UTF_8);
//                            statement.getObject().getDefinition().getName().setEn(nameEnSub + "-" + nameEn);
//
//                            ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//                            json = ow.writeValueAsString(statement);
//                        }
//                        if (json != null) {
//                            // System.out.println(json);
//                            doPost(local, json);
//                        }
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }
//
//        closeConnection();
//    }
//
//    private void statementExamCompleted(boolean local) throws IOException {
//        openConnectionLamsMet();
//        SimpleDateFormat sdfSource = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
//        Predmet cs120 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("id", 1042l)).uniqueResult();
//        Predmet it131 = (Predmet) genericDao.getSession().createCriteria(Predmet.class).add(Restrictions.eq("sifra", "IT131")).uniqueResult();
//        List<Overa> overaList = genericDao.getSession().createCriteria(Overa.class).add(Restrictions.or(Restrictions.eq("predmetId", cs120), Restrictions.eq("predmetId", it131))).createCriteria("upisId").add(Restrictions.eq("skolskaGodinaId", SkolskaGodinaUtil.getInstance().trenutnaSkolskaGodina(genericDao.getSession()))).list();
//
//        Set<Student> studentList = new HashSet<>();
//
//        for (Overa overa : overaList) {
//            studentList.add(overa.getUpisId().getStudentId());
//        }
//        for (Student student : studentList) {
//            IsumUser user = student.getIsumUserId();
//
//            String sql = "select login_name, finish_date as finish_date, title, r.assessment_uid as assessment_id, r.maximum_grade, r.grade " + "from tl_laasse10_assessment_result r " + "join tl_laasse10_assessment a on r.assessment_uid = a.uid " + "join tl_laasse10_user u on r.user_uid = u.uid " + "where (title like '%IT131%' or title like '%CS120%') and login_name like '" + user.getUsername() + "' and finish_date is not null;";
//
//            try {
//                ResultSet rs = lamsConnection.getStmt().executeQuery(sql);
//                while (rs.next()) {
//                    ExamCompletedIledaStatement statement = new ExamCompletedIledaStatement();
//
//                    ExamCompletedIledaActor actor = new ExamCompletedIledaActor(user.getUsername(), "mailto:" + user.getMail());
//
//                    ExamCompletedIledaDisplay display = new ExamCompletedIledaDisplay("Completed");
//                    ExamCompletedIledaVerb verb = new ExamCompletedIledaVerb(display, IledaVerbType.COMPLETED);
//                    statement.setActor(actor);
//                    statement.setVerb(verb);
//
//                    String dateStr = rs.getString("finish_date");
//                    Date date = sdfSource.parse(dateStr);
//
//                    statement.setTimestamp(sdfDestination.format(date));
//                    statement.getContext().getContextActivities().getGrouping().get(1).setId("http://lams.metropolitan.ac.rs:8080/course=" + rs.getString("title").split("-")[0]);
//                    statement.getContext().getContextActivities().getGrouping().get(1).getDefinition().getName().setEn(rs.getString("title").split("-")[0]);
//                    statement.getContext().getContextActivities().getOther().get(0).setId("http://lams.metropolitan.ac.rs:8080/attempt=7&cmid=" + rs.getInt("assessment_id"));
//
//                    statement.getObject().setId("http://lams.metropolitan.ac.rs:8080/quizId= " + rs.getInt("assessment_id"));
//
//                    statement.getResult().getScore().setMax(rs.getDouble("maximum_grade"));
//                    statement.getResult().getScore().setMin(0);
//                    statement.getResult().getScore().setRaw(rs.getDouble("grade"));
//                    if (statement.getResult().getScore().getRaw() > 0) {
//                        statement.getResult().getScore().setScaled(rs.getDouble("grade") / rs.getDouble("maximum_grade"));
//                    } else {
//                        statement.getResult().getScore().setScaled(0.0);
//                    }
//                    statement.getObject().getDefinition().getExtensions().put("https://w3id.org/learning-analytics/learning-management-system/external-id", "");
//                    String nameEn = new String(rs.getBytes("title"), StandardCharsets.UTF_8);
//                    statement.getObject().getDefinition().getName().setEn(nameEn);
//
//                    ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//                    String json = ow.writeValueAsString(statement);
//                    //  System.out.println(json);
//                    doPost(local, json);
//
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        closeConnection();
//    }



    // This code is extracted from the context of the information system, so parts that rely on specific classes do not work outside the context of another project.

    @Override
    public void fillLRS(boolean local) throws Exception {

//        statementLogin(local);
//        statementSubmissionUploadedAndCompleted(local);
//        statementSubmissionGraded(local);
//        statementSubmissionUploadedAndCompleted(local);
//        statementSubmissionGraded(local);
//        statementExamEntered(local);
//        statementExamStarted(local);
//        statementExamReceived(local);
//        statementQuestionTrueFalse(local);
//        statementQuestionMultiple(local);
//        statementExamCompleted(local);
    }
}
