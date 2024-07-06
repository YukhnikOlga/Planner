import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearch1SimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        Todos todos = new Todos();

        todos.add(simpleTask);
        String query = "Позвонить родителям";

        Task[] expected = {simpleTask};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearch1Meeting() {
        Meeting meeting = new Meeting(
                55,
                "Наследование и расширяемость систем",
                "Проблемы наследования",
                "05.07.24"
        );

        Todos todos = new Todos();

        todos.add(meeting);
        String query = "Наследование и расширяемость систем";

        Task[] expected = {meeting};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

  @Test
    public void shouldSearch1Epic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(555, subtasks);
        Todos todos = new Todos();

        todos.add(epic);
        String query = "Молоко";

        Task[] expected = {epic};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSomeSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(5, "Позвонить детям");
        SimpleTask simpleTask3 = new SimpleTask(5, "Позвонить бабушке");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        String query = "Позвонить бабушке";

        Task[] expected = {simpleTask3};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSomeMeeting() {
        Meeting meeting = new Meeting(
                55,
                "Наследование и расширяемость систем",
                "Проблемы наследования",
                "05.07.24"
        );

        Meeting meeting2 = new Meeting(
                66,
                "Мастер и Маргарита",
                "Булгаков",
                "06.07.24"
        );

        Meeting meeting3 = new Meeting(
                77,
                "Метро",
                "Глуховский",
                "07.07.24"
        );


        Todos todos = new Todos();

        todos.add(meeting);
        todos.add(meeting2);
        todos.add(meeting3);
        String query = "Глуховский";

        Task[] expected = {meeting3};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSomeEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб" };
        String[] subtasks2 = {"Шахматы", "Шашки", "Нарды" };
        String[] subtasks3 = {"Июнь", "Июль", "Август" };
        Epic epic = new Epic(555, subtasks);
        Epic epic2 = new Epic(666, subtasks2);
        Epic epic3 = new Epic(777, subtasks3);
        Todos todos = new Todos();

        todos.add(epic);
        todos.add(epic2);
        todos.add(epic3);
        String query = "Шахматы";

        Task[] expected = {epic2};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNoSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Todos todos = new Todos();

        todos.add(simpleTask);
        String query = "Позвонить детям";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNoMeeting() {
        Meeting meeting = new Meeting(
                55,
                "Наследование и расширяемость систем",
                "Проблемы наследования",
                "05.07.24"
        );

        Todos todos = new Todos();

        todos.add(meeting);
        String query = "Мастер и Маргарита";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchNoEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(555, subtasks);

        Todos todos = new Todos();

        todos.add(epic);
        String query = "Шахматы";

        Task[] expected = {};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSomeTasks() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        SimpleTask simpleTask2 = new SimpleTask(5, "Сходить в библиотеку");
        SimpleTask simpleTask3 = new SimpleTask(5, "Позвонить детям");
        SimpleTask simpleTask4 = new SimpleTask(5, "Позвонить бабушке");
        SimpleTask simpleTask5 = new SimpleTask(5, "Поиграть с соседом");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(simpleTask2);
        todos.add(simpleTask3);
        todos.add(simpleTask4);
        todos.add(simpleTask5);
        String query = "Позвонить";

        Task[] expected = {simpleTask, simpleTask3, simpleTask4};
        Task[] actual = todos.search(query);
        Assertions.assertArrayEquals(expected, actual);
    }
}
