package game;

import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        fight(getRandomCharacter(),getRandomCharacter());
    }
    //There is a bug in your decision, it occurs when two hobbits fight, it goes into an endless cycle. Because they have no damage. In my solution I provided for this
    public static void fight(Character hero, Character hero2){
        if (hero.getClass().getSimpleName().equalsIgnoreCase("hobbit") && hero.getClass().getSimpleName().equalsIgnoreCase(hero2.getClass().getSimpleName())) {
            System.out.printf("We are Hobbits and we are brothers");
            return;
        }
        while (hero.isAlive() && hero2.isAlive()){
                hero.kick(hero2);
                hero2.kick(hero);
            }if(hero.isAlive()){
                System.out.println(hero.getClass().getSimpleName()+" - WIN");
                return;
            }if (hero2.isAlive()){
                System.out.println(hero.getClass().getSimpleName()+" - WIN");
                return;
            } else {
            System.out.println("Fight between :"+hero.getClass().getSimpleName()+" and "+hero2.getClass().getSimpleName()+" - ended in a draw");
            }
    }

    @SneakyThrows
    public static Character getRandomCharacter(){
        Reflections reflections = new Reflections("game");
        Set<Class<? extends Character>> clas = reflections.getSubTypesOf(Character.class);
        return clas.stream().filter(cl -> !Modifier.isAbstract(cl.getModifiers()))
               .collect(Collectors.toList()).get(Character.randomGen(0,clas.size()))
               .getDeclaredConstructor().newInstance();
    }

}
