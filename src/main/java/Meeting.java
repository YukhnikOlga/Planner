public class Meeting extends Task {
    protected String topic;
    protected String project;
    protected String start;

    public Meeting(int id, String topic, String project, String start) {
        super(id); // вызов родительского конструктора
        this.topic = topic; // заполнение своих полей
        this.project = project;
        this.start = start;
    }
// Meeting — задача, описывающая назначенную встречу. Про неё известны id — число, topic — тема обсуждения,
// project — название проекта, который будут обсуждать, и start — дата и время старта текстом.

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        if (start.contains(query)) {
            return true;
        }
        return false;
    }
}
// Переопределите метод matches для двух оставшихся классов. Для SimpleTask это можно сделать одним if,
// для Epic — циклом перебирая подзадачи и также проверяя каждую через if.


