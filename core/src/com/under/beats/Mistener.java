package com.under.beats;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.files.FileHandle;

import java.util.Arrays;

import static com.under.beats.Graph.but_changeName;
import static com.under.beats.Graph.but_reset;
import static com.under.beats.Graph.but_soundMUS;
import static com.under.beats.Graph.but_soundSFX;
import static com.under.beats.Graph.goOut;
import static com.under.beats.Graph.menuAction;
import static com.under.beats.Graph.notif;
import static com.under.beats.Graph.prefs;
import static com.under.beats.Graph.time;
import static com.under.beats.Graph.timetap;

public class Mistener implements InputProcessor {

    static int tx,ty,ux,uy,dx,dy;
    static boolean onScreen = false;
    static boolean doubleTap=true;
    static boolean firsttap = false;
    @Override
    public boolean keyDown(int keycode) {

        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        tx = screenX;
        ty = screenY;
        onScreen=true;


        System.out.println(timetap);
        if(!firsttap)
        {
            doubleTap= Graph.timetap < 15;
        }
        timetap=0;
        firsttap = false;
        if(!Graph.dialog)
        switch (Graph.act)
        {
            case 0:
                Button rus = new Button(709 - 530, 195, 498, 330);
                Button eng = new Button(709, 195, 498, 330);

                if(Graph.lang.equals("none")) {
                    if (rus.isPressed(screenX, screenY))
                    { selectSound();}
                    if (eng.isPressed(screenX, screenY))
                    {selectSound();}
                }
                break;

            case 1:

                Graph.skip=true;
                break;

            case 3:
                if(!Graph.done) {
                    Button[] key = new Button[26];
                    String keys = "qwertyuiopasdfghjklzxcvbnm";
                    for (int i = 0; i < 10; i++) {
                        key[i] = new Button(Graph.keyboardX + i * 119, Graph.keyboardY, 85, 83);
                    }
                    //asdfghjkl

                    float shiftAlil = 41;
                    for (int i = 0; i < 9; i++) {
                        key[i + 10] = new Button(Graph.keyboardX + i * 119 + shiftAlil - 11, Graph.keyboardY + 118, 85, 83);
                    }

                    //zxcvbnm

                    shiftAlil = 79;
                    for (int i = 0; i < 7; i++) {
                        key[i + 19] = new Button(Graph.keyboardX + i * 119 + shiftAlil - 15, Graph.keyboardY + 118 * 2, 85, 83);

                    }

                    for (int i = 0; i < key.length; i++) {
                        if (key[i].isPressed(screenX, screenY)) {
                            Graph.keybool[i] = true;
                            selectSound();
                        }
                    }

                    Button enter = new Button(1072,630,255,100);
                    Button shift = new Button(51,630,261,100);
                    Button backspace = new Button( 487,630,473,100);
                    if(enter.isPressed(screenX,screenY))
                        if(Graph.isEnterActive){Graph.enterIsPressed=true;}
                    if(shift.isPressed())
                    { Graph.shiftIsPressed=true;}

                    if(backspace.isPressed())
                    {
                        Graph.backspaceIsPressed=true;
                    }

                }
                break;

            case 4:
                if(!Graph.showMenu)
                {
                    if(doubleTap)Graph.showMenu=!Graph.showMenu;
                    doubleTap=false;
                }
                if(Graph.showMenu)
                if(menuAction==0){
                    if (Graph.but_play.isPressed(screenX, screenY)) {
                        selectSound();

                    }
else
                    if (Graph.but_create.isPressed(screenX, screenY)) {
                        selectSound();
                    }
else
                    if (Graph.but_settings.isPressed(screenX, screenY)) {
                        selectSound();
                    }
else
                    if (Graph.but_extras.isPressed(screenX, screenY)) {
                        selectSound();
                    }
                    else  if(doubleTap)Graph.showMenu=!Graph.showMenu;
                }


                if(menuAction==1)
                {
                    if(but_reset.isPressed(Mistener.tx,Mistener.ty))
                    {
                        selectSound();
                    }
                    if(Graph.but_lang.isPressed(Mistener.tx,Mistener.ty))
                    {
                        selectSound();
                    }
                    if(but_changeName.isPressed(Mistener.tx,Mistener.ty))
                    {
                        selectSound();
                    }

                    if(but_soundMUS.isPressed(Mistener.tx,Mistener.ty))
                    {
                        selectSound();
                    }

                    if(but_soundSFX.isPressed(Mistener.tx,Mistener.ty))
                    {
                        selectSound();
                    }

                    if(Graph.but_back.isPressed(Mistener.tx,Mistener.ty))
                    {
                        selectSound();
                    }

                }
                break;

            case 5:

                break;

            case 6:
                if(Graph.but_up.isPressed(screenX,screenY))
                {
                    selectSound();
                }

                if(Graph.but_left.isPressed(screenX,screenY))
                {
                    selectSound();
                }

                if(Graph.but_right.isPressed(screenX,screenY))
                {
                    selectSound();
                }

                if(Graph.but_play.isPressed(screenX,screenY))
                {
                    selectSound();
                }

                break;
        }
         else
        {
            if(!Graph.dialmsgY.equals(Graph.dialmsgN))
            if(Graph.yos.isPressed(screenX,screenY)) {
                selectSound();
            }
            if(Graph.nuu.isPressed(screenX,screenY)) {
                selectSound();
            }
        }
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(Graph.DEBUG)System.out.println(tx+","+ty+","+dx+","+dy);
        ux = screenX;
        uy = screenY;
        onScreen=false;

        if(notif.isPressed(screenX,screenY))
            Graph.notTime=400;

        if(!Graph.dialog)
        switch (Graph.act) {
            case 0:
            Button rus = new Button(709 - 530, 195, 498, 330);
            Button eng = new Button(709, 195, 498, 330);

                if(Graph.lang.equals("none")) {
                    if (rus.isPressed(screenX, screenY))
                    {Graph.setLang("rus"); chooseSound();}
                    if (eng.isPressed(screenX, screenY))
                    {Graph.setLang("eng");chooseSound();}
                }
            break;

            case 2:
                if(Graph.time>150)
                if(Graph.firstPlay)
                    Graph.act=3;
                else
                    Graph.act = 4;

                break;




            case 3:
                Graph.enterIsPressed = false;
                Graph.backspaceIsPressed = false;
                Graph.shiftIsPressed = false;
                if(!Graph.done) {
                    Arrays.fill(Graph.keybool, false);

                    Button[] key = new Button[26];
                    char[] keys = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM".toCharArray();
                    for (int i = 0; i < 10; i++) {
                        key[i] = new Button(Graph.keyboardX + i * 119, Graph.keyboardY, 85, 83);
                    }
                    //asdfghjkl

                    float shiftAlil = 41;
                    for (int i = 0; i < 9; i++) {
                        key[i + 10] = new Button(Graph.keyboardX + i * 119 + shiftAlil - 11, Graph.keyboardY + 118, 85, 83);
                    }

                    //zxcvbnm

                    shiftAlil = 79;
                    for (int i = 0; i < 7; i++) {
                        key[i + 19] = new Button(Graph.keyboardX + i * 119 + shiftAlil - 15, Graph.keyboardY + 118 * 2, 85, 83);

                    }

                    for (int i = 0; i < key.length; i++) {
                        if (key[i].isPressed(screenX, screenY)) {
                            if(Graph.name.length()<6)Graph.name += (Graph.isShift) ? keys[i + 26] : keys[i];
                            Graph.isShift = false;
                        }
                    }

                    Button enter = new Button(1072,630,255,80);
                    Button shift = new Button(51,630,261,79);
                    Button backspace = new Button( 487,630,473,79);
                    if(enter.isPressed(screenX,screenY))
                        if(Graph.isEnterActive){Graph.done=true;chooseSound();prefs.putBoolean("isPlayed",true);prefs.putString("name",Graph.name);prefs.flush();}
                    if(shift.isPressed())
                    { Graph.isShift=!Graph.isShift;selectSound();}

                    if(backspace.isPressed())
                    {
                        selectSound();
                        char[] old = Graph.name.toCharArray();
                        if(old.length>0)
                        {
                            Graph.name = "";

                            for(int i = 0; i<old.length-1;i++)
                                Graph.name+=old[i];
                        }
                    }

                }


                break;

            case 4:
                if(Graph.showMenu)
                    if(menuAction==0){
                    if (Graph.but_play.isPressed(screenX, screenY)) {
                        chooseSound();
                        menuAction = 4;
                    }

                    if (Graph.but_create.isPressed(screenX, screenY)) {
                        chooseSound();
                        //Graph.notification("It is doesnt done yet!");
                        Graph.act=5;

                    }

                    if (Graph.but_settings.isPressed(screenX, screenY)) {
                        chooseSound();
                       //
                        Graph.LmenuAction = menuAction;
                        menuAction=1;
                    }

                    if (Graph.but_extras.isPressed(screenX, screenY)) {
                        chooseSound();
                        menuAction = 2;
                       // Graph.dialog("Данная кнопка пока не готова. Ожидайте обновлений.");
                    }



                }

                if(Graph.menuAction == 1)
                {
                    if(but_reset.isPressed(screenX,screenY))
                    {

                        chooseSound();
                        Graph.dialog(Graph.res_areusure,Graph.uhum+"#",Graph.nene);
                    }
                    if(Graph.but_lang.isPressed(screenX,screenY))
                    {
                        chooseSound();

                        int langn = 0;

                        for(int i = 0;i<Graph.langarr.length;i++)
                        {
                            if(Graph.langarr[i][1].equals(Graph.lang))langn=i+1;
                        }

                        if(langn>=Graph.langarr.length)langn=0;
                        Graph.setLang(Graph.langarr[langn][1]);
                    }
                    if(but_changeName.isPressed(screenX,screenY))
                    {
                        chooseSound();
                        Graph.but_changename();
                    }

                    if(but_soundMUS.isPressed(screenX,screenY))
                    {
                        chooseSound();
                        Graph.settedvolumeMUS+=0.2f;
                        if(Graph.settedvolumeMUS>1.19)Graph.settedvolumeMUS=0;
                        Graph.setVolume(Graph.settedvolumeMUS,Graph.settedvolumeSFX,true);
                    }

                    if(but_soundSFX.isPressed(screenX,screenY))
                    {
                        Graph.settedvolumeSFX+=0.2f;
                        if(Graph.settedvolumeSFX>1.19)Graph.settedvolumeSFX=0;
                        Graph.setVolume(Graph.settedvolumeMUS,Graph.settedvolumeSFX,true);
                        chooseSound();
                    }



                }

                if(Graph.but_back.isPressed(screenX,screenY))
                {
                    chooseSound();
                    if(Graph.menuAction!=0)Graph.LmenuAction = menuAction;
                    menuAction=0;
                }

                break;


            case 5:

                if(Graph.isBattleOpen)
                {
                    // if(screenX>1440*Graph.position-26&&screenX<1440*Graph.position+26)System.out.println("uwu");
                    Button b = new Button(1440*Graph.position-26,529,51,52);
                    if(b.isPressed(tx,ty))
                    {
                        Graph.position+=dx/1440f;
                        Graph.batTheme.setPosition(Graph.position*Graph.musDur);
                        Graph.playALil=20;
                        // Graph.batTheme.play();
                    }

                    Button pl = new Button(720 - 43, 638, 43 * 2,  79);
                    if(pl.isPressed(screenX,screenY)){Graph.playSound = !Graph.playSound;}

                    Button rev = new Button(622-37,666,37,25);
                    Button forw = new Button(720-622+720,666,37,25);
                    Button toChose = new Button(24,14,74,70);
                    if(toChose.isPressed(screenX,screenY))
                    {
                        Graph.isBattleOpen=false;
                        Graph.position=0;
                        Graph.playSound=false;
                        Graph.batTheme.stop();
                    }
                    if(rev.isPressed(screenX,screenY))
                    {
                        Graph.batTheme.setPosition(Graph.batTheme.getPosition()-0.5f);
                        Graph.playALil=10;
                    }

                    if(forw.isPressed(screenX,screenY))
                    {
                        Graph.batTheme.setPosition(Graph.batTheme.getPosition()+0.5f);
                        Graph.playALil=10;
                    }

                }else
                {
                    FileHandle[] f = Gdx.files.internal("C:\\Users\\Ilia-\\OneDrive\\Рабочий стол\\UnderBeatsData").list();

                    Button back = new Button(205 - 41, 593, 41 * 2,  83);
                    Button up = new Button(1192, 593, 41 * 2,  83);
                    Button add  = new Button(720 - 65, 584, 65 * 2,  124);
                    if(back.isPressed(screenX,screenY))if(Graph.levelPage>0)Graph.levelPage--;
                    if(up.isPressed(screenX,screenY)) {
                        if(f.length-(7*Graph.levelPage)>=7)
                            Graph.levelPage++;
                    }

                    for(int i = 0;( i+7*Graph.levelPage)<f.length&&i<7;i++) {

                        Button b = new Button(206, 85 + 66 * i, 1028, 65);
                        if (b.isPressed(Mistener.tx, Mistener.ty))
                            Graph.openBattle(f[i+7*Graph.levelPage].name());
                    }

                }

                break;

            case 6:
                if(Graph.but_up.isPressed(screenX,screenY))
                {
                    chooseSound();
                    goOut=true;
                }

                if(Graph.but_left.isPressed(screenX,screenY))
                {
                    chooseSound();
                   if (Graph.choosenLev>0)Graph.choosenLev--;else Graph.notification(Graph.onlineGame);
                }

                if(Graph.but_right.isPressed(screenX,screenY))
                {
                    chooseSound();
                    if(Graph.choosenLev<Graph.levOpened-1)
                    Graph.choosenLev++;
                }

                if(Graph.but_play.isPressed(screenX,screenY))
                {
                   // chooseSound();
                   // Graph.dialog("trying to get\nacess to "+Graph.levelData[Graph.choosenLev][0]+"...\nACCESS DENIED","oh no","oh no");
                    Graph.startBattle(Graph.levelData[Graph.choosenLev][0]);
                }

                break;

        }
        else
        {
            if(!Graph.dialmsgY.equals(Graph.dialmsgN))
            if(Graph.yos.isPressed(screenX,screenY)) {
                Graph.proceedDialog(Graph.dialmsgY);
                chooseSound();
            }

            if(Graph.nuu.isPressed(screenX,screenY)) {
                Graph.proceedDialog(Graph.dialmsgN);
                chooseSound();
            }
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        dx = screenX-tx;
        dy = screenY-ty;
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }


    public void chooseSound()
    {
        Graph.select.play(Graph.settedvolumeSFX);

    }

    public void selectSound()
    {
        Graph.select2.play(Graph.settedvolumeSFX);

    }

}
