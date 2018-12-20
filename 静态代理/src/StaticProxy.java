//测试方法
public class StaticProxy {
    public static void main(String[] agrs){
        Actor actor = new Actor("I am a famous fator!");
        Agent agent = new Agent(actor,"I am an agent.","That is all.");
        agent.speak();
    }
}
