import util.ShotNote;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.util.List;

/**
 * @description:
 * @author: Andy
 * @time: 2020/10/25 22:39
 */

public class test2 {
    public static void main(String[] args) {
      /*  ShotNote shotNote = new ShotNote();
        String facial = shotNote.getVerify("17121571006", "MGame", "¡¾", "¡¿");
        System.out.println(facial);*/
      ShotNote shotNote = new ShotNote();
        List<String> note = shotNote.getNote("+86");
        for (String s : note) {
            System.out.println(s);
        }

    }
}
