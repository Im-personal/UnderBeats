package com.under.beats;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Audio;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Arrays;

import sun.font.TrueTypeFont;

public class Graph extends ApplicationAdapter {
	static Preferences prefs;
	ShapeRenderer sr;
	SpriteBatch b;
	//Mistener.tx,Mistener.ty,Mistener.dx,Mistener.dy
	//Textures
	Texture img;
	Texture yellow;
	Texture darkblue;
	Texture dyellow;
	Texture add;
	Texture segment;
	Texture playBat;
	Texture pauseBat;
	Texture smolArrow;
	Texture mark;
	Texture star;
	Texture rus;
	Texture eng;
	Texture blackPix;
	Texture whitePix;
	Texture grayPix;
	Texture downButton;
	Texture downButtonY;
	Texture redSoul;
	Texture levThing;
	Texture levThingUnactived;
	Texture chosLev;
	Texture buttonUp;
	Texture buttonUpY;
	Texture buttonLeft;
	Texture buttonLeftY;
	Texture buttonRight;
	Texture buttonRightY;

	static Texture play,settings,extras,create;
	static Texture playA,settingsA,extrasA,createA;

	static Texture[] storypics = new Texture[11];
	static Texture[] background = new Texture[6];
	Texture mainlogo;
	//SOUNDS


	static Sound select;
	static Sound select2;
	static Sound autorsound;
	static Sound batEnocouter;
	//MUSICS
	static Music oggloop;
	static Music story;
	static Music intronoice;
     static Music selectedStory;
     static Music enterName;
	static Music shine;
	static Music batTheme;
	//FONTS;

	//BOOLEANS
	static boolean DEBUG = true;
	static boolean firstPlay = true;
	static boolean done = false;
	static boolean keyboard = false;
	static boolean isShift = true;
	static boolean[] keybool=new boolean[26];
	static boolean enterIsPressed = false;
	static boolean shiftIsPressed = false;
	static boolean backspaceIsPressed = false;
	static boolean playSound=false;
	//INTS
	static int screenWidth, screenHeight;
	static int act = 0;
	static int wordint = 0;
	int checkLogo = 0;
	int bg = 1;
	static int timetap = 0;
	static int HP = 20;
	static int LV = 1;
	static int maxHP = 20;
	//FLOATS
	static float mnX = 1;
	static float mnY = 1;
	static float keyboardX = 0, keyboardY = 0;

	//FONTS
	BitmapFont determinationSmol;
	BitmapFont determinationMiddleWhite;
	BitmapFont determinationMiddleYellow;
	BitmapFont determinationBigWhite;
	BitmapFont determinationBigYellow;
	BitmapFont determinationBigGray;
	BitmapFont cryptomorrowSmolGray;
	BitmapFont cryptomorrowSmolWhite;
	//FONT WIDTHS
	float determinationMiddleWhiteWidth = 31;
	float cryptomorrowSmolWhiteWidth = 27;
	float cryptomorrowSmolGrayWidth = 27;
	float determinationBigWhiteWidth = 50;
	float determinationSmolWidth = 23;

	//STRINGS
	static String[] storyText;
	static String nameTheFallenHuman;
	static String[][] answers;
	static String shift;
	static String backspace;
	static String Enter;
	static String name = "";
	static String Settings = "";
	static String soundMus = "";
	static String soundSFX = "";
	static String language = "";
	static String changeName = "";
	static String reset = "";
	static String[][] langarr = {{"Русский","rus"},{"English","eng"}};
	static String res_areusure;
	static String res_AREUSURE;
	static String uhum;
	static String nene;
	static String close;
	static String thereIsNothingYet;
	static String onlineGame;
	static String[][] levelData={{"Test","src"},{"Test2","src"},{"Test3","src"},{"Test2","src"},{"Test3","src"},{"Test3","src"},{"Test2","src"},{"Test3","src"}};
	static String playBut;
	public void loadBackground()
	{
		for(int i = 0; i<6;i++)
		{
			background[i] = new Texture("bg"+(i+1)+"_"+bg+".png");
		}

		stars = new float[20][2];
		for(int i = 0; i<stars.length;i++)
		{
			stars[i][0]=1440+(1440f/stars.length)*i;
			stars[i][1]=(float)Math.random()*700f;
		}

		switch (bg)
		{
			case 1:
				bgskale[0] = new float[]{871,353,488,1200,871};
				bgskale[1] = new float[]{845*2,231,503+64,845*2-1,845*2};
				bgskale[2] = new float[]{1320,339, 356/*-20*/,1000,850};
				bgskale[3] = new float[]{1431,382,292/*-30*/,1431+88,1431};
				bgskale[4] = new float[]{798, 614,84/*-143*/,1000,797};
				bgskale[5] = new float[]{1419, 460,196/*-140*/,1416,1416};



				break;
		}

	}

	public void loadTextures()
	{
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		buttonLeft = new Texture("BackButtonLeft.bmp");
		buttonLeftY = new Texture("BackButtonLeftSelected.bmp");

		buttonRight = new Texture("BackButtonRightSelected.bmp");
		buttonRightY = new Texture("BackButtonRightSelectedY.bmp");

		buttonUp = new Texture("UpButtonRightSelected.bmp");
		buttonUpY = new Texture("UpButtonRightSelectedY.bmp");

		chosLev = new Texture("GameSpriteselectd.png");
		redSoul = new Texture("redSoul.bmp");
		levThing = new Texture("level.bmp");
		levThingUnactived = new Texture("GameSpriteUnactived.png");
		rus = new Texture("Russian.png");
		eng = new Texture("American.png");
		img = new Texture("badlogic.jpg");
		mainlogo = new Texture("underbeats.png");
		for(int i = 0; i<11;i++)
		{
			storypics[i]=new Texture("logo"+(i+1)+".png");
		}
		star = new Texture("star.png");


		blackPix = new Texture("blackpixel.png");
		whitePix = new Texture("whitepixel.png");
		grayPix = new Texture("graypixel.png");

		downButton = new Texture("down.bmp");
		downButtonY = new Texture("downy.bmp");

		yellow = new Texture("buttons\\yellow.png");
		dyellow = new Texture("buttons\\dyellow.png");
		darkblue = new Texture("buttons\\darkblue.png");
		add = new Texture("buttons\\addElement.png");
		segment = new Texture("buttons\\segment.png");
		playBat = new Texture("buttons\\play.png");
		pauseBat = new Texture("buttons\\pause.png");
		smolArrow = new Texture("buttons\\horis.png");
		mark = new Texture("buttons\\mark.png");

		loadBackground();

	}

	public void loadSounds()
	{
		select = Gdx.audio.newSound(Gdx.files.internal("select.wav"));
		select2 = Gdx.audio.newSound(Gdx.files.internal("select3.wav"));
		autorsound = Gdx.audio.newSound(Gdx.files.internal("think.wav"));
		batEnocouter = Gdx.audio.newSound(Gdx.files.internal("bateno.mp3"));
	}
	public void loadFonts()
	{

		determinationSmol = generateFont("determination.ttf",2f,2f);

		determinationMiddleWhite = generateFont("determination.ttf",2.5f,2.5f);



		determinationMiddleYellow = generateFont("determination.ttf",2.5f,2.5f,Color.YELLOW);

		cryptomorrowSmolGray = generateFont("cryptoftomorrow.ttf",2f,2f,new Color(0.3f,0.3f,0.3f,1));

		cryptomorrowSmolWhite = generateFont("cryptoftomorrow.ttf",2f,2f);



		determinationBigWhite = generateFont("determination.ttf",4f,4f);


		determinationBigYellow = generateFont("determination.ttf",4f,4f,Color.YELLOW);


		determinationBigGray = generateFont("determination.ttf",4f,4f,new Color(0.4f,0.4f,0.4f,1f));
		determinationBigGray.getData().setScale(4f*mnX,4f*mnY);
		determinationBigGray.setColor(new Color(0.4f,0.4f,0.4f,1f));

	}

	public void loadMusics()
	{
		oggloop = Gdx.audio.newMusic(Gdx.files.internal("mus_oogloop.ogg"));
		story = Gdx.audio.newMusic(Gdx.files.internal("onceuponatime.mp3"));
		intronoice = Gdx.audio.newMusic(Gdx.files.internal("lastnoise.wav"));
		selectedStory = Gdx.audio.newMusic(Gdx.files.internal("story.mp3"));
		enterName = Gdx.audio.newMusic(Gdx.files.internal("mus_menu.mp3"));
		shine = Gdx.audio.newMusic(Gdx.files.internal("wzzz.mp3"));
	}


	public void loadSave()
	{
		prefs = Gdx.app.getPreferences("Underbeats");
		log("GO ON!!!!!!!!!!!!!!!!!!!");

			firstPlay = !prefs.getBoolean("isPlayed");



		if(!firstPlay)
		{
			lang = prefs.getString("language");
			name = prefs.getString("name");
			settedvolumeSFX = prefs.getFloat("volumeSFX");
			settedvolumeMUS = prefs.getFloat("volumeMus");
			setVolume(settedvolumeMUS,settedvolumeSFX);


		}
		else
		{


			prefs.putFloat("volumeMus",1);
			prefs.putFloat("volumeSFX",1);
			setVolume(1,1);
		}


	}


	@Override
	public void create () {

		screenHeight = Gdx.graphics.getHeight();
		screenWidth = Gdx.graphics.getWidth();
		mnX = screenWidth/1440f;//1440 720
		mnY = screenHeight/720f;





		Arrays.fill(keybool, false);


//if(DEBUG)act = 4;
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);


	//System.out.println(screenWidth+";"+screenHeight);
	//mn = 0.5f;

						Gdx.input.setInputProcessor(new Mistener());

		sr = new ShapeRenderer();
		b = new SpriteBatch();

		loadTextures();
		loadFonts();
		loadMusics();
		loadSounds();
		loadSave();

		if(firstPlay)
			act=0;
		else {
			act = 1;
			setLang(lang);
		}

		for(int i = 0; i<moveBG.length;i++)
		{
			for(int j = 0; j<moveBG[i].length;j++)
			{
				moveBG[i][j]=j*bgskale[i][3];
			}
		}






		//determinationSmol = True


	}


	//


	public void soundManager()
	{
		//log(mnX+";"+mnY);
	//	bgskale[1] = new float[]{845*2,231,503,845*2-1};
		///bgskale[5] = new float[]{1416, Mistener.dy,196,1416,1416};
		//bgskale[2] = new float[]{Mistener.dx,Mistener.dy,Mistener.ty,1000,Mistener.dx};
		//moveBG[0][1]+=Mistener.dx;
		//act=4;


			//bgskale[0] = new float[]{871,353,488,1200,871};
				//bgskale[1] = new float[]{845*2,231,503,845*2-1,845*2};
			//bgskale[2] = new float[]{1320,339, 356,1000,850};
					//bgskale[3] = new float[]{1431,382,292+,1431+88,1431};
				//bgskale[4] = new float[]{798, 614,84,1000,797};
				//bgskale[5] = new float[]{1417, 460,196+Mistener.dy,1416,1416};//*/


		if(act==0)
		{
			if(!oggloop.isPlaying())
			{
				oggloop.setLooping(true);
				oggloop.play();
			}
		}
		else
		{
			if(oggloop.isPlaying())
				oggloop.stop();
		}

		if(act==1)
		{
			if(!story.isPlaying()) {
				story.setVolume(settedvolumeMUS);
				if(time<5)story.play();
				else {act++;time=0;/*story.setPosition(0);*/log(148);}
			}

		}
		else
		{
			if(story.isPlaying())story.stop();
		}

		if(act==2)
		{
			//if(!intronoice.isPlaying())
			//{
			//place of the suffer
			if(time<5)intronoice.play();


		//	}
		}



		if(act==4)
		{
			if(checkLogo==4)

			if(!selectedStory.isPlaying())
			{
				selectedStory.play();
				selectedStory.setLooping(true);
			}
		}

		if(act==3)
		{
			if(done)
			{
				if(enterName.isPlaying())
					enterName.stop();

				if(ztm<0.5f)
					if(!shine.isPlaying())
						shine.play();
			}

			else

			{
				if(!enterName.isPlaying())
				{
					enterName.setLooping(true);
					enterName.play();
				}
			}

		}

	}

	public void countData() {
		timetap++;
		try {
			firstPlayCount();
			if (act == 1) storyCount();
			if (act == 2) countIntro();
			if (act == 3) countEnterName();
			if (act == 4) countMenu();
			if(act==5)countBattleCreator();
			if (act == 6) countGamePrepare();
			if (act == 7) countBattle();
		}catch (RuntimeException e)
		{
			dialog("An Error!\n"+e.toString(),true);
		}
	}

	public void drawSprites()
	{
		try {
			firstPlaySPRT();
			if (act == 1) storySPRT();
			if (act == 2) drawIntro();
			if (act == 3) drawEnterName();
			if (act == 4) drawMenu();
			if(act==5)drawBattleCreator();
			if (act == 6) drawGamePrepare();
			if (act == 7) drawBattle();
			if (dialog) drawDialogWindow();
			drawNotification();
		}
		catch (RuntimeException e)
		{
			dialog("An Error!\n"+e.toString(),true);
		}
	}

	public void drawShapes()
	{
		Gdx.gl.glEnable(GL20.GL_BLEND);
		Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		try {
			firstPlaySHP();
			storySHP();
			if (act == 3) enterNameSHP();
			if (act == 4) menuSHP();
			if (act == 6) drawGamePrepareSHP();
		}
		catch (RuntimeException e)
		{
			dialog("An Error!\n"+e.toString(),true);
		}

	}
//v144,314,1101,104





	static  boolean isBattleOpen=false;
	static int levelPage;
	static float position = 0f;
	static float musDur=0;



	public void countBattleCreator()
	{
		if(isBattleOpen) {

			if(!playSound) {

				if (playALil > 0) {
					playALil--;
					if (!batTheme.isPlaying()) batTheme.play();
				} else {
					if (batTheme.isPlaying()) batTheme.pause();
				}
			}
			else
			{
				if(!batTheme.isPlaying())batTheme.play();
				playALil=0;
			}

			if (batTheme.isPlaying()) {
				position = batTheme.getPosition() / musDur;
				if(position>1){position=1;batTheme.pause();}
			}
			if(position>1)position=1;
		}
	}
	public void drawBattleCreator()
	{

		if(isBattleOpen)
		{


			draw(yellow,0,0,1440,70);

			draw(buttonLeft,24,14,74,70);
			//draw(buttonLeft,Mistener.tx - Mistener.dx, Mistener.ty, Mistener.dx * 2,  Mistener.dy);
			draw(add,720 - 69, 12, 69 * 2,  124);

			for(int i = 0;20*i<1440;i++)
				draw(segment,20*i,615,20,21);

			//	draw(yellow,Mistener.tx,Mistener.ty,Mistener.dx,Mistener.dy);
			draw(!playSound?playBat:pauseBat,720 - 43, 638, 43 * 2,  79);
			draw(smolArrow,622,666,-37,25);
			draw(smolArrow,720-622+720,666,37,25);
			Button b = new Button(1440*Graph.position-26,529,51,52);
			if(position+(b.isPressed(Mistener.tx,Mistener.ty)?Mistener.dx/1440f:0)>0)
				if(position+(b.isPressed(Mistener.tx,Mistener.ty)?Mistener.dx/1440f:0)<1)
					draw(mark,(1440f*(position+(b.isPressed(Mistener.tx,Mistener.ty)?Mistener.dx/1440f:0))-52/2f),530,52,95);
				else
					draw(mark,1414,530,52,95);
			else
				draw(mark,-26,530,52,95);


		}
		else {
			draw(yellow, 720 - 514, 56, 514 * 2, 720 - 56 * 2);
			FileHandle[] f = Gdx.files.external("\\sdcard").list();
			for(int i = 0;( i+7*levelPage)<f.length&&i<7;i++) {

				Button b = new Button(206,85+66*i,1028,65);
				if(b.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen)
					draw(dyellow,206,85+66*i,1028,65);
				drawString(f[i+7*levelPage].name(), 260, 101 + 66 * i, determinationSmol);
			}


			Button back = new Button(205 - 41, 593, 41 * 2,  83);
			Button up = new Button(1192, 593, 41 * 2,  83);
			Button adda = new Button(720 - 65, 584, 65 * 2,  124);

			if(back.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen)
				b.setColor(Color.YELLOW);else b.setColor(Color.WHITE);
			draw(buttonLeft,205 - 41, 593, 41 * 2,  83);
			if(adda.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen)
				b.setColor(Color.YELLOW);else b.setColor(Color.WHITE);
			draw(add,720 - 65, 584, 65 * 2,  124);
			if(up.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen)
				b.setColor(Color.YELLOW);else b.setColor(Color.WHITE);
			draw(buttonLeft,1233 +41, 593, -41 * 2,  83);
			b.setColor(Color.WHITE);
//draw(buttonLeft,Mistener.tx - Mistener.dx, Mistener.ty, Mistener.dx * 2,  Mistener.dy);
		}

	}

	static int battleTimer;
	static float x=720-13;
	static float y=438+13+800+Graph.menuScreenMove-153;

	static float targetX=100;
	static float targetY=100;

	static float moveX=0;
	static float moveY=0;
	public void countBattle()
	{
		battleTimer++;

		if(battleTimer==50/2)
		{
			moveX = Math.abs(x-targetX)/60;
			moveY = Math.abs(y-targetY)/60;
		}

		if(battleTimer>50/2)
		{
		//	log((x>targetX)+";"+(y>targetY)+";"+moveX+";"+moveY);
			if(x<targetX)x+=moveX;
			if(x>targetX)x-=moveX;
			if(y>targetY)y-=moveY;
			if(y<targetY)y+=moveY;
		}

	}

	public void drawBattle()
	{
	//	battleTimer++;
		if(!(battleTimer>=9/2&&battleTimer<=17/2)&&!(battleTimer>=22/2&&battleTimer<=30/2))
		draw(redSoul,x,y,26,26);
	}


	public void countGamePrepare()
	{
		if(goOut)
		{
			if(menuScreenMove<0)menuScreenMove+=10;
			if(menuScreenMove>=0){act=4;menuScreenMove = -200; menuAction=0;LmenuAction=1;goOut=false;}
		}
		else
		if(menuScreenMove>-800)menuScreenMove-=10;


		if(levmove<1440/2f-distance*choosenLev)levmove+=10;
		if(levmove>1440/2f-distance*choosenLev)levmove-=10;

		shi-=0.01f;
		if(shi<0)shi=1;



		but_left = new Button(351,572+800+menuScreenMove,110,110);
		but_right = new Button(978,572+800+menuScreenMove,110,110);
		but_up = new Button(1275,20+800+menuScreenMove,128,128);
		but_play = new Button(720-251/2f,559+800+menuScreenMove-95,251,75);
	}
	static float shi = 1f;
	static  int choosenLev = 0;
	float levmove = 1440/2f;//1440/2f;
	float distance = 200;
	static int levOpened = 3;


	static Button but_left;
	static Button but_right;
	static Button but_up;

	static boolean goOut = false;
	public void drawGamePrepare()
	{



		drawString(name,60,17+800+menuScreenMove,cryptomorrowSmolWhite);
		drawString("LV "+LV+" HP "+HP+"/"+maxHP,60+cryptomorrowSmolWhiteWidth*7,17+800+menuScreenMove,cryptomorrowSmolWhite);

		float shiftalittle=-153;

		draw(whitePix,Math.max(0,levmove),525+800+menuScreenMove+shiftalittle,1436,2);
		//draw(levThing,458,508+800+menuScreenMove,37,36);

		for(int i = 0; i<levelData.length;i++)
		{
			if(i<levOpened)
			draw(levThing,levmove+distance*i-37/2f,508+800+menuScreenMove+shiftalittle,37,36);
			else
				draw(levThingUnactived,levmove+distance*i-37/2f,508+800+menuScreenMove+shiftalittle,37,36);
			if(i==choosenLev)draw(chosLev,levmove+distance*i-37/2f,508+800+menuScreenMove+shiftalittle,37,36);

		}


		b.setColor(new Color(1f,1f,1f,shi));
	//	draw(redSoul,720-13,438+13,26,26);


		draw(redSoul,720-(13*(1+(1-shi))),438+26-(13*(1+(1-shi)))+800+menuScreenMove+shiftalittle,26*(1+(1-shi)),26*(1+(1-shi)));

		b.setColor(Color.WHITE);
		draw(redSoul,720-13,438+13+800+menuScreenMove+shiftalittle,26,26);


		drawBox(720-452/2f,559+800+menuScreenMove,452,139,20);

		if(but_right.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen)
			draw(buttonRightY,978,572+800+menuScreenMove,110,110); else
			draw(buttonRight,978,572+800+menuScreenMove,110,110);

		if(but_left.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen)
			draw(buttonLeftY,351,572+800+menuScreenMove,110,110); else
			draw(buttonLeft,351,572+800+menuScreenMove,110,110);

		if(but_up.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen)
		draw(buttonUpY,1275,20+800+menuScreenMove,128,128);else
			draw(buttonUp,1275,20+800+menuScreenMove,128,128);


		if(but_play.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen)
		drawBoxG(720-251/2f,559+800+menuScreenMove-95,251,75,10);else
			drawBox(720-251/2f,559+800+menuScreenMove-95,251,75,10);



		drawCentredString(playBut,720,493+800+menuScreenMove,determinationMiddleWhite,determinationMiddleWhiteWidth);

		drawCentredStringSep(levelData[choosenLev][0],720-determinationMiddleWhiteWidth,570+800+menuScreenMove,determinationMiddleWhite,"\n",452,determinationMiddleWhiteWidth);

	}

	public void drawGamePrepareSHP()
	{
		for(int i = 0;i<maxHP;i++)
		{
			if(i<=HP)sr.setColor(Color.YELLOW);else sr.setColor(Color.RED);
			fillRect(60+cryptomorrowSmolWhiteWidth*21+i*4,17+800+menuScreenMove,4,cryptomorrowSmolGrayWidth);
		}
	}

	static float logoX=144f+52, logoY=314f,logoW=1101f,logoH=98f;//277,130,782,75 in game
	void countMenu()
	{
		checkLogo=0;
		if(logoX<199f)logoX+=(199f-144f)/60f; else checkLogo++;
		if(logoY>48f)logoY-=(314f-48f)/60f; else checkLogo++;
		if(logoW>1079f)logoW-=(1101f-1079f)/60f; else checkLogo++;
		if(logoH<104f)logoH+=(104f-98f)/60f; else checkLogo++;

// 199 48 1079 135
		for(int i = 0;i<6;i++)
		{
			for(int j = 0;j<2;j++) {
				moveBG[i][j] -= movespeed / ((5-i) + 1);
				if (moveBG[i][j] < -bgskale[i][4])
				{
					if(j==0)moveBG[i][j] = moveBG[i][1]+bgskale[i][3];
					else
						moveBG[i][j] = moveBG[i][0]+bgskale[i][3];
				}
			}
		}

		if(checkLogo>=4) {
			for (int i = 0; i < stars.length; i++) {
				stars[i][0] -= movespeed / 0.5f;
				if (stars[i][0] < 0) {
					stars[i][1] = (float) Math.random() * 700f;
					stars[i][0] = 1440f;
				}
			}
			//for(int i = 0; i<(Mistener.onScreen?5:1);i++)
			switch (menuAction)
			{
				case 0:
				case 2:
					menuScreenMove/=1.01f;
					break;

				case 1:
					if(menuScreenMove<720/6f)
					menuScreenMove++;





					break;
			}

			but_reset = new Button(578,592-(840)+menuScreenMove*7,262,58);

			but_changeName = new Button(436,480-(840)+menuScreenMove*7,444,89);
			but_lang = new Button(948,380-(840)+menuScreenMove*7,444,90);



		}




//1 - настройки
		//
		// 2 - extras
		// 3  - create
		//4 - play

		/*
		* draw(play,448,213+(menuScreenMove*(7)),526,218);
		draw(create,448,(213+218+20)+(menuScreenMove*(7)),162,162);
		draw(extras,448+20+162,(213+218+20)+(menuScreenMove*(7)),162,162);
		draw(settings,448+40+162*2,(213+218+20)+(menuScreenMove*(7)),162,162);
		* */
		but_play = new Button(448,213+(menuScreenMove*(7)),526,218);
		but_create = new Button(448,(213+218+20)+(menuScreenMove*(7)),162,162);
		but_extras = new Button(448+20+162,(213+218+20)+(menuScreenMove*(7)),162,162);
		but_settings = new Button(448+40+162*2,(213+218+20)+(menuScreenMove*(7)),162,162);
		but_soundSFX = new Button(966,315-22-(840)+menuScreenMove*7,382,63);
		but_soundMUS = new Button(966,199-22-(840)+menuScreenMove*7,382,63);
		but_back = new Button(126,511-(840)+menuScreenMove*7,154,154);

		if(menuAction==2)
		{
			if(extrasy > 60)extrasy-=20;
			but_back = new Button(925,506,370,119);
		}else
		{
			extrasy = 720f/2;

		}

		if(menuAction==0)but_back=new Button(0,0,-1,-1);
		if(menuAction==4)
		{
			if(menuScreenMove>-200)
			menuScreenMove--;
			else {
				act += 2;
				menuScreenMove=0;
			}
		}
	}

	static float extrasy = 720/2f;
	static float[][] stars;
	static int menuAction = 0;
	static int LmenuAction = 0;
	float movespeed = 2.5f;
	float[][] moveBG = new float[6][2];
	float[][] bgskale = new float[6][2];
	static float menuScreenMove = 458*2;
	static Button but_play = new Button(448,213+(menuScreenMove*(7)),526,218);
	static Button but_create = new Button(448,(213+218+20)+(menuScreenMove*(7)),162,162);
	static Button but_extras = new Button(448+20+162,(213+218+20)+(menuScreenMove*(7)),162,162);
	static Button but_settings = new Button(448+40+162*2,(213+218+20)+(menuScreenMove*(7)),162,162);
	public void drawMenu()
	{
	//	menuScreenMove=Mistener.dy*2;

		for(int i = 0; i<stars.length;i++)
		{
			draw(star,stars[i][0],stars[i][1]-499+(menuScreenMove*(0.5f)),10,20);
		}


		for(int i = 0; i<6;i++)
		{
			for(int j = 0; j<2;j++)
			draw(background[5-i],moveBG[5-i][j],bgskale[5-i][2]+(menuScreenMove*(i+1)),bgskale[5-i][0],bgskale[5-i][1] );
		}

		if(showMenu) {
			if (but_play.isPressed(Mistener.tx, Mistener.ty) && Mistener.onScreen)
				draw(playA, 448, 213 + (menuScreenMove * (7)), 526, 218);
			else
				draw(play, 448, 213 + (menuScreenMove * (7)), 526, 218);

			if (but_create.isPressed(Mistener.tx, Mistener.ty) && Mistener.onScreen)
				draw(createA, 448, (213 + 218 + 20) + (menuScreenMove * (7)), 162, 162);
			else
				draw(create, 448, (213 + 218 + 20) + (menuScreenMove * (7)), 162, 162);

			if (but_extras.isPressed(Mistener.tx, Mistener.ty) && Mistener.onScreen)
				draw(extrasA, 448 + 20 + 162, (213 + 218 + 20) + (menuScreenMove * (7)), 162, 162);
			else
				draw(extras, 448 + 20 + 162, (213 + 218 + 20) + (menuScreenMove * (7)), 162, 162);

			if (but_settings.isPressed(Mistener.tx, Mistener.ty) && Mistener.onScreen)
				draw(settingsA, 448 + 40 + 162 * 2, (213 + 218 + 20) + (menuScreenMove * (7)), 162, 162);
			else
				draw(settings, 448 + 40 + 162 * 2, (213 + 218 + 20) + (menuScreenMove * (7)), 162, 162);
		}
//459,463,155,143
//162
//20
		draw(mainlogo,logoX,logoY+((menuAction==0&&LmenuAction==0)?0:menuScreenMove*7),logoW,logoH);
		//draw(mainlogo,Mistener.tx,Mistener.ty,Mistener.dx,Mistener.dy);


		if(menuAction==1||LmenuAction==1)
		{
			float shi = 33;
			float anoshi = 0;
			float prelastshi = 341;
			float lolshi = 104;
			drawString(Settings,137,76-(840)+menuScreenMove*7,determinationBigWhite);
			drawString(soundMus,137+anoshi,76-(840)+menuScreenMove*7+(determinationMiddleWhiteWidth*3f)+shi,determinationMiddleWhite);
			drawString(soundSFX,137+anoshi,76-(840)+menuScreenMove*7+(determinationMiddleWhiteWidth*3f)*2+shi,determinationMiddleWhite);
			drawString(language,137+anoshi,76-(840)+menuScreenMove*7+(determinationMiddleWhiteWidth*3f)*3+shi,determinationMiddleWhite);
			drawString(changeName,137+anoshi+prelastshi,76-(840)+menuScreenMove*7+(determinationMiddleWhiteWidth*3f)*4+shi,(but_changeName.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen)?determinationMiddleYellow:determinationMiddleWhite);
			drawString(reset,137+anoshi+prelastshi+lolshi,76-(840)+menuScreenMove*7+(determinationMiddleWhiteWidth*3f)*5+shi,(but_reset.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen)?determinationMiddleYellow:determinationMiddleWhite);

			int langn = 0;

			for(int i = 0;i<langarr.length;i++)
			{
				if(langarr[i][1].equals(lang))langn=i;
			}

			drawCentredString(langarr[langn][0],137+anoshi+1046,determinationMiddleWhiteWidth/2+76-(840)+menuScreenMove*7+(determinationMiddleWhiteWidth*3f)*3+shi,(but_lang.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen)?determinationMiddleYellow:determinationMiddleWhite,determinationMiddleWhiteWidth);


			{
				float timx = 966, timy = 315-22, timw = 382, timh = 63;
				draw(blackPix, timx, timy-(840)+menuScreenMove*7, timw, timh);
				for (int i = 0; i < 5 * settedvolumeSFX; i++) {


				draw(but_soundSFX.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen?grayPix:whitePix, timx + (timw / 5f * i), timy + (timh / 5f * (4 - i))-(840)+menuScreenMove*7, timw / 5f * 0.8f, timh - (timh / 5f * (4 - i)));

				}
			}

		//	float timx =Mistener.tx, timy = Mistener.ty,timw = Mistener.dx,timh=Mistener.dy;
			float timx = 966, timy = 199-22, timw = 382, timh = 63;
			draw(blackPix, timx, timy-(840)+menuScreenMove*7, timw, timh);
			for (int i = 0; i < 5 * settedvolumeMUS; i++) {


				draw(but_soundMUS.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen?grayPix:whitePix, timx + (timw / 5f * i), timy + (timh / 5f * (4 - i))-(840)+menuScreenMove*7, timw / 5f * 0.8f, timh - (timh / 5f * (4 - i)));

			}


			draw((but_back.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen)?downButtonY:downButton,126,511-(840)+menuScreenMove*7,154,154);

		}

		if(menuAction==2)
		{
			drawBox(90,extrasy,((1440f/2f)-90)*2,((720f/2f)-extrasy)*2,30);

			if(extrasy<=60) {
				if (but_back.isPressed(Mistener.tx, Mistener.ty) && Mistener.onScreen)
					drawBoxG(925, 506, 370, 119, 10);
				else
					drawBox(925, 506, 370, 119, 10);

				drawCentredString(close, 925 + 370f / 2, 506 + 119 / 2f, determinationBigWhite,determinationBigWhiteWidth);

				//drawCentredStringSep(thereIsNothingYet,1440/2f,202,determinationSmol,"\n",((1440f/2f)-90)*2);

				float shiftX=200;
				float shiftY=122;
				drawString("cryptomorrowSmolWhite",shiftX+20,shiftY+20,cryptomorrowSmolWhite);
				drawString("cryptomorrowSmolGray",shiftX+20,shiftY+20*4,cryptomorrowSmolGray);
				drawString("determinationMiddleWhite",shiftX+20,shiftY+20*8,determinationMiddleWhite);
				drawString("determinationBigWhite",shiftX+20,shiftY+20*12,determinationBigWhite);
				drawString("determinationSmol",shiftX+20,shiftY+20*16,determinationSmol);
				//drawString("cryptomorrowSmolGray",20,20*20,cryptomorrowSmolGray);


			}
		}


	}
	static boolean showMenu = true;
	static Button but_back = new Button(126,511-(840)+menuScreenMove*7,154,154);
	static Button but_reset = new Button(578,592-(840)+menuScreenMove*7,262,58);
	static Button but_changeName = new Button(436,480-(840)+menuScreenMove*7,444,89);
	static Button but_lang = new Button(948,380-(840)+menuScreenMove*7,444,90);
	static Button but_soundMUS = new Button();
	static Button but_soundSFX = new Button();
	public void menuSHP()
	{
		sr.setColor(Color.BLACK);
		fillRect(0,117+720+menuScreenMove*6,1440,800);
		//sr.setColor(new Color(1f,0f,0f,0.5f ));
		//fillRect(Mistener.tx,Mistener.ty,Mistener.dx,Mistener.dy);
	}




		float savemnX = 0;
	float savemnY = 0;
	public void countEnterName()
	{
		keyboard=true;
		if(done) {
			ztm += 0.0035f;
			mnX+=ztm/100;
			mnY+=ztm/100;
			if(ztm>=1&&!shine.isPlaying())
			{
				mnX=savemnX;
				mnY = savemnY;
				act++;
			}
		}
		else
		{
			//savemn = mn;
			savemnX = mnX;
			savemnY = mnY;
		}
	}
	static boolean isEnterActive = false;
	public void  drawEnterName()
	{
		drawString(nameTheFallenHuman,184,73,determinationBigWhite);
		drawString(name,535,197,determinationBigWhite);

		String out ="nothing";
		for(int i = 1; i<answers.length;i++)
		{
			if(name.toLowerCase().equals(answers[i][0]))
			{
				isEnterActive = (answers[i][2].equals("p"));
				out = answers[i][1];

			}
		}

		int check = 1;

		for(int i = 1;i<name.length();i++)
		{
			if(name.toLowerCase().toCharArray()[i-1]==name.toLowerCase().toCharArray()[i])check++;
		}

	if(check==6) {
		out = answers[answers.length - 1][1];
		isEnterActive=true;
	}

		if(out.equals("nothing")){out=answers[0][1];isEnterActive=true;}
		if(name.length()>0)
		drawString(out,283,161,determinationSmol);
		else
			isEnterActive=false;
		keyboardX=52/2+130;
		keyboardY=290;

		if("gaster".equals(name.toLowerCase())) {
			act = 1;
			story = Gdx.audio.newMusic(Gdx.files.internal("onceuponatime.mp3"));
			time = 0;
			enterName.stop();
			name = "";
		}

		drawKeyboard(5);

	}

	public void drawKeyboard(float dist)
	{
		float x = keyboardX;
		float y = keyboardY;
		int shift = isShift?1:0;
		//qwertyuiop
		char[] line = "qwertyuiopQWERTYUIOP".toCharArray();
		int lineshift = shift*10;
		for(int i = 0; i<10;i++)
		{
			float randX = (float)(Math.random()*dist*2-dist);
			float randY = (float)(Math.random()*dist*2-dist);
			drawString(line[lineshift+i]+"",randX+x+i*119,randY+y,keybool[i]?determinationBigYellow:determinationBigWhite);
		}
		//asdfghjkl
		line = "asdfghjklASDFGHJKL".toCharArray();
		lineshift = shift*9;
		float shiftAlil =41;
		for(int i = 0; i<9;i++)
		{
			float randX = (float)(Math.random()*dist*2-dist);
			float randY = (float)(Math.random()*dist*2-dist);
			drawString(line[lineshift+i]+"",shiftAlil+randX+x+i*119,randY+y+118,keybool[i+10]?determinationBigYellow:determinationBigWhite);
		}

		//zxcvbnm
		lineshift = shift*7;
		line = "zxcvbnmZXCVBNM".toCharArray();
		shiftAlil =  79;
		for(int i = 0; i<7;i++)
		{
			float randX = (float)(Math.random()*dist*2-dist);
			float randY = (float)(Math.random()*dist*2-dist);
			drawString(line[lineshift+i]+"",randX+x+i*119+shiftAlil,randY+y+118*2,keybool[i+19]?determinationBigYellow:determinationBigWhite);
		}

		if(isEnterActive)
			if(enterIsPressed)
				drawString(Enter,1072,604,determinationBigYellow);
			else
		drawString(Enter,1072,630,determinationBigWhite);
		else
			drawString(Enter,1072,630,determinationBigGray);

		if(shiftIsPressed)
			drawString(Graph.shift,51,630,determinationBigYellow);
		else
			drawString(Graph.shift,51,630,determinationBigWhite);


		if(backspaceIsPressed)
			drawString(backspace,487,630,determinationBigYellow);
		else
			drawString(backspace,487,630,determinationBigWhite);
		//*/
	}


	public  void enterNameSHP()
	{

		sr.setColor(new Color(1,1,1,ztm));
		fillRect(0,0,1440,720);
	}




	public void drawIntro()
	{
		if(time>50||intronoice.isPlaying())//277,130,782,103 in game
		draw(mainlogo,144,314,1101,104);
		if(time>150)//logoX=144, logoY=314,logoW=1101,logoH=104  199 48 1079 135
			drawString(tapToContinue,52+474,429,cryptomorrowSmolGray);
	}
	static String tapToContinue;

	public void countIntro()
	{

			time++;
			ztm = 0;
			ztm2 = 0;
			frame = 0;
			lasttime = 0;
			volume = settedvolumeMUS;
			skip = false;
			smztm = false;
			wordint = 0;
			logoX = 144;
			logoY = 314;
			logoW = 1101;
			logoH = 98;
			if(time==800)
			{
				story = Gdx.audio.newMusic(Gdx.files.internal("onceuponatime.mp3"));
			}
			if (time > 1000) {
				act--;
				time = 0;
				//story.setPosition(0);
				//story.dispose();
			}


	}


	int frame = 0;
	boolean smztm = false;
	int lasttime=0;
	static int time = 0;
	float shiftY=0;
	float volume = 1;
	static float settedvolumeMUS = 1;
	static float settedvolumeSFX = 1;
	static boolean skip = false;
	public void storyCount()
	{time++;
		if(act==1) {
			for(int i = 0; i<(Mistener.onScreen?5:1);i++)
			if(skip&&act==1) {
				ztm2 += 0.005f;
				volume-=0.005f;
				story.setVolume(volume);
				if(ztm2 >= 1){act++;story.stop();story.setVolume(1f);time = 0;log(232);}
			}

			if (((int) story.getPosition() + 1) % 6 == 0||(int) story.getPosition()==28) smztm = true;
			if ((int) story.getPosition() % 6 == 0) {//log(lasttime+"!="+story.getPosition());
				if (lasttime != (int) story.getPosition()) {
					lasttime = (int) story.getPosition();

					frame++; wordint = 0;
				}
			}
			if(frame>=10)smztm=false;

			if(frame>=11&&frame<=13)shiftY++;
			if(frame==13)ztm2+=0.01f;
			if(frame==4)ztm=1.5f;
			if (smztm) {
				ztm += 0.05f;
				if (ztm >= 1) smztm = false;
			} else {
				if (ztm > -1) ztm -= 0.05f;
			}
			if(frame<10)
			if(time%5==0&&wordint<storyText[frame].length()){wordint++;if(wordint<storyText[frame].length())if(storyText[frame].toCharArray()[wordint]!='`'&&storyText[frame].toCharArray()[wordint]!=' ')autorsound.play();}
			if(time<5&&!skip)ztm2=0;

		}
	}

	public void storySPRT()
	{
		if(frame<10)
		draw(storypics[frame],52+314,84+shiftY,696,378);
		else
		{
			draw(storypics[10],52+314,84+shiftY-378*2.21f,696,378*3.21f);
		}
	//	drawString(""+ztm,50,50,determinationSmol);
if(frame<10)		drawStringByLetters(storyText[frame],/*355*/52+334,492,determinationMiddleWhite,'|','`',wordint,84);



	}

	public void storySHP()
	{
		if(act==1) {
			sr.setColor(new Color(0, 0, 0, ztm));
			fillRect(52+314,84,696,378);

			if(frame>=10)
			{
				sr.setColor(Color.BLACK);
				fillRect(52+314,84+378,696,500);
				fillRect(52+314,0,696,84);
			}
			sr.setColor(new Color(0,0,0,ztm2));
			fillRect(0,0,1440f,720f);

		}
	}



	public void firstPlaySPRT()
	{
		if(act==0) {

			//if(lang.equals("none")||lang.equals("eng"))
			draw(eng, 52+709, 195, 498, 330);
			//if(lang.equals("none")||lang.equals("rus"))
			draw(rus, 52+709 - 530, 195, 498, 330);
		}


	}
	public void firstPlayCount()
	{
		if(act==0)
		{
			if(lang.equals("none")) {
				if(ztm>0)ztm -= 0.005f;
			}
			else
			{
				if(ztm2>=1) {
					ztm += 0.005f;
					if(ztm>=1.2f)
					{
						if(oggloop.isPlaying())
							oggloop.stop();
					}
					if(ztm>=1.5f)
					{
						act++;log(325);
					}
				}
				else
					ztm2+=0.01f;
			}
		}
	}
	static float ztm = 1f;
	static float ztm2 = 0f;
	static String lang = "none";
	public void firstPlaySHP()
	{
		if(act==0) {
			sr.setColor(new Color(0, 0, 0, ztm));
			fillRect(0,0,1440f,720f);

			if(!lang.equals("none"))
			{
				sr.setColor(new Color(0,0,0,ztm2));
				if(lang.equals("rus"))
					fillRect(52+709, 195, 498, 330);
				if(lang.equals("eng"))
					fillRect(52+709 - 530, 195, 498, 330);
			}

		}
	}


	boolean firstTime = true;
	@Override
	public void render () {




		ScreenUtils.clear(0, 0, 0, 1);
		soundManager();
		countData();

		b.begin();


		drawSprites();

		b.end();



		sr.begin(ShapeRenderer.ShapeType.Filled);
		drawShapes();
		sr.end();

	}




	public void draw(Texture txr, float x, float y,float w, float h)
	{
		b.draw(txr, (x)*mnX, (720-y-h)*mnY, w*mnX, h*mnY);
	}

	public void fillRect( float x, float y,float w, float h)
	{
		sr.rect((x)*mnX, (720-y-h)*mnY, w*mnX, h*mnY);
	}

	public void drawString(String str, float x, float y, BitmapFont font)
	{
		font.draw(b,str,x*mnX,(720f-y)*mnY);
	}

	public void drawCentredString(String str, float x, float y, BitmapFont font,float width)
	{
		font.draw(b,str,(x-(str.length()*width)/2)*mnX,((720f-y)+width/2)*mnY);
	}

	public void drawCentredStringSep(String str, float x, float y, BitmapFont font, String sep,float widofbox,float width)
	{
		String fin="";
		int brr = 0;
		for(int i = 0; i<str.length();i++) {
			fin += str.charAt(i);
			if(brr>=widofbox/width) {
				fin += '\n'; brr=-1;
			}
			brr++;

			if(fin.charAt(i)=='\n')brr=0;
		}

		String[] words = fin.split(sep);
		for(int i = 0; i<words.length;i++)
		font.draw(b,words[i],((x-(words[i].length()*width)/2)+ width)*mnX,((720f-y)-i*(width*1.5f))*mnY);
	}

	public int contains(String str, char cont)
	{
		int n=0;
		char[] c = str.toCharArray();
		for (char value : c) if (value == cont) n++;
			return n;
	}





	public void drawStringByLetters(String str, float x, float y, BitmapFont font,char nextLine, char nothing,int upto,float dist)
	{

		int lines = contains(str,nextLine)+1;
		char[] arr = str.toCharArray();
		String[] out = new String[lines];
		Arrays.fill(out, "");
		int j=0;
		for(int i = 0; (i<arr.length)&&(i<upto);i++)
		{
			if(arr[i]!=nextLine) {
				if (arr[i] != nothing) out[j] += arr[i];
			}
			else
				j++;
		}

		for(int i = 0;i<lines;i++)
		font.draw(b,out[i],x*mnX,(720f-y-i*dist)*mnY);
	}

	void log()
	{
		System.out.println("DEBUG!!");
	}

	void log(int i)
	{
		System.out.println(i);
	}

	void log(String str)
	{
		System.out.println(str);
	}

	void log(boolean bool)
	{
		System.out.println(bool);
	}

	void log(char c)
	{
		System.out.println(c);
	}

	void log(float f)
	{
		System.out.println(f);
	}

	@Override
	public void dispose () {
		b.dispose();
		img.dispose();
		rus.dispose();
		eng.dispose();
		oggloop.dispose();
		select.dispose();
		select2.dispose();
		oggloop.dispose();
		story.dispose();
	}


	public static void setLang(String lang)
	{


		Graph.lang = lang;
		prefs.putString("language",lang);
		prefs.flush();
		switch (lang)
		{
			case "rus":
				playBut = "Начать";
				onlineGame = "Онлайн игра еще недоступна";
				thereIsNothingYet = "Тут пока ничего нет\nБыть может я добавлю \nчто нибудь \nпотом...";
				close = "Закрыть";
				res_areusure = "Вы уверены?\nВсе данные будут\nуничтожены.";
				res_AREUSURE = "ВЫ УВЕРЕНЫ?\nМожет лучше нажать\n-НЕТ-?";
				uhum = "Да";
				nene = "НЕТ";
				Settings = "Настройки";
				soundMus = "Громкость музыки";
				soundSFX = "Громкость эффектов";
				language = "Язык";
				changeName = "Изменить имя";
				reset = "Сброс";

				play = new Texture("PlayButtonR.png");
				playA = new Texture("PlayButtonRA.png");
				settings = new Texture("SettingButton.bmp");
				settingsA = new Texture("SettingButtonA.bmp");
				extras = new Texture("ExtrasButton.bmp");
				extrasA = new Texture("ExtrasButtonA.bmp");
				create= new Texture("CreateButton.bmp");
				createA= new Texture("CreateButtonA.bmp");

				storyText =new String[]{
						"Давным-давно две расы|правили Землей:|ЛЮДИ и МОНСТРЫ.",
						"Но однажды между ними|вспыхнула война.",
						"После продолжительной|битвы людям удалось|одержать победу.",
						"И с помощью волшебного|заклятия они заключили|монстров под землю.",
						"Много лет спустя.````````````.````````````.",
						"     ГОРА ЭБОТТ|        201X",
						"Легенды гласят, что те,|кто взобрался на гору,|никогда не возвращались.",
						"",
						"",
						"",
						"",
				};
				tapToContinue = "tap to continue";

				nameTheFallenHuman = "Имя упавшего человека:";
				answers = new String[][]
						{
								{"","Выбрать это имя?","p"},
								{"chara","Истинное имя.","p"},
								{"asriel","...","n"},
								{"papyru","Я ПОЗВОЛЯЮ!!!","p"},
								{"gaster","Ещё рано.","n"},
								{"alphys","Н-не делай этого.","n"},
								{"flowey","Я уже ВЫБРАЛ это имя.","n"},
								{"undyne","Придумай СВОЁ имя.","n"},
								{"sans","не-а","n"},
								{"toriel","Я думаю, тебе следует выбрать другое имя, моё дитя.","n"},
								{"asgore","Ты не можешь.","n"},
								{"peha","crococow.","p"},
								{"rena","crococow.","p"},
								{"srpelo","НЕ ТРОЖЬ ДИТЯ!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!","p"},
								{"murder","Слегка в точку, да?..","p"},
								{"mersy","Слегка в точку, да?..","p"},
								{"catty","Брэтти, Брэтти! Это МОЁ имя!","p"},
								{"bratty","Ну, типа, окей, наверное.","p"},
								{"temmie","пРИВ!","p"},
								{"aaron","Выбрать это имя? ;)","p"},
								{"woshua","Очисть имя.","p"},
								{"metta","ООО! РЕКЛАМИРУЕШЬ МОЙ БРЕНД?","p"},
								{"mtt","ООО! РЕКЛАМИРУЕШЬ МОЙ БРЕНД?","p"},
								{"mett","ООО! РЕКЛАМИРУЕШЬ МОЙ БРЕНД?","p"},
								{"jerry","Джерри.","p"},
								{"alphy","Эм.... окей?","p"},
								{"napsta",".........(Он не в силах остановить тебя.)","p"},
								{"blooky",".........(Он не в силах остановить тебя.)","p"},
								{"bpants","Вы опустились на самое дно","p"},
								{"gerson","Ва-ха-ха! Почему бы и нет?","p"},
								{"shyren","...?","p"},
								{"hapa","нинаю","p"},
								{"nara","нинаю","p"},
								{"cro","cocow.","p"},
								{"croc","ocow.","p"},
								{"croco","cow.","p"},
								{"crococ","ow.","p"},
								{"crocow","А где КО?","p"},
								{"artem","Ченить))))","p"},
								{"aya","Мята - лучшее лекарство!","p"},
								{"debug","АБВГ!?(*:.,<>","n"},
								{"aaaaaaa","Не очень креативно...?","p"}

						};
				 shift = "Shift";
				backspace = "Стереть";
				Enter = "Готово";




				break;

			case "eng":
				playBut = "Start";
				thereIsNothingYet = "There is nothing yet\nmaybe ill add \nanything\nlater...";
				onlineGame = "The online game is not available yet";
				close = "Close";
				uhum = "Yes";
				nene = "NO";
				Settings = "Settings";
				soundMus = "Volume of music";
				soundSFX = "Volume of SFX";
				language = "Language";
				changeName = "Change name";
				reset = "Reset";

				res_areusure = "Are you sure?\nAll data will be\ncollapsed.";
				res_AREUSURE = "ARE YOU SURE?\nMaybe it is better\nto press\n-NO-?";

				play = new Texture("PlayButton.bmp");
				playA = new Texture("PlayButtonA.bmp");
				settings = new Texture("SettingButton.bmp");
				settingsA = new Texture("SettingButtonA.bmp");
				extras = new Texture("ExtrasButton.bmp");
				extrasA = new Texture("ExtrasButtonA.bmp");
				create= new Texture("CreateButton.bmp");
				createA= new Texture("CreateButtonA.bmp");


				storyText =new String[]{
						"Long ago, two races|ruled over Earth:|HUMANS and MONSTERS.",
						"One day, war broke|out between the two|races.",
						"After a long battle,|the humans were victorious.",
						"They sealed the monsters|underground with a magic|spell.",
						"Many years later.````````````.````````````.",
						"     MT. EBOTT|        201X",
						"Legends say that those|who climb the mountain|never return.",
						"",
						"",
						"",
						"",
				};
				tapToContinue = "tap to continue";

				nameTheFallenHuman = "Name the fallen human.";
				answers= new String[][]
						{
								{"","Is this name correct?","p"},
								{"chara","The true name.","p"},
								{"asriel","...","n"},
								{"papyru","I'LL ALLOW IT!!!","p"},
								{"gaster","It's too early","n"},
								{"alphys","D-don't do that!","n"},
								{"flowey","I already CHOOSE that name.","n"},
								{"undyne","Get your OWN name!","n"},
								{"sans","nope","n"},
								{"toriel","I think you should think of your own name, my child","n"},
								{"asgore","You cannot.","n"},
								{"peha","crococow.","p"},
								{"rena","crococow.","p"},
								{"srpelo","DON'T TOUCH DA CHILD!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!","p"},
								{"murder","That's a little on-the-nose, isn't it...?","p"},
								{"mersy","That's a little on-the-nose, isn't it...?","p"},
								{"catty","Bratty! Bratty! That's MY name!","p"},
								{"bratty","Like, OK i guess.","p"},
								{"temmie","hOI!","p"},
								{"aaron","Is this name correct? ;)","p"},
								{"woshua","Clean name.","p"},
								{"metta","OOOOH!!! ARE YOU PROMOTING MY BRAND?","p"},
								{"mtt","OOOOH!!! ARE YOU PROMOTING MY BRAND?","p"},
								{"mett","OOOOH!!! ARE YOU PROMOTING MY BRAND?","p"},
								{"jerry","Jerry.","p"},
								{"alphy","Uh... OK?","p"},
								{"napsta",".........(They are powerless to stop you.)","p"},
								{"blooky",".........(They are powerless to stop you.)","p"},
								{"bpants","You are really scraping the bottom of the barrel","p"},
								{"gerson","Wah ha ha! Why not?","p"},
								{"shyren","...?","p"},
								{"hapa","idk","p"},
								{"nara","idk","p"},
								{"cro","cocow.","p"},
								{"croc","ocow.","p"},
								{"croco","cow.","p"},
								{"crococ","ow.","p"},
								{"crocow","Where is the CO?","p"},
								{"aloxi","You're NOT","p"},
								{"sabosa","THE QUEEN APPEARED","p"},
								{"michel","So tiny and meow!","p"},
								{"artem","Smth))))","p"},
								{"fwisk","Only the special one can choose this-","p"},
								{"will","I love you cookie<3","p"},
								{"meggy","The Meg of the sea B)","p"},
								{"nihal","I believe in you.","p"},
								{"alpha","Good i mean","p"},
								{"aaaaaaa","Not very creative...?","p"}
						};
				shift = "Shift";
				backspace = "Backspace";
				Enter = "Enter";
				break;
		}

	}



	private BitmapFont generateFont(String fontName, float sizeX, float sizeY, float w, float h) {

		String RUSSIAN_CHARACTERS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
				+ "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
				+ "1234567890.,:;_¡¿?\"'+-*/()[]={}<>!"+
				"abcdefghijklmnopqrstuvwxyz" +
				"ABCDEFGHIJGKLMNOPQURSTUVWXYZ";


		// Configure font parameters
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.characters =RUSSIAN_CHARACTERS;
		parameter.size = 24;

		// Generate font
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator( Gdx.files.internal(fontName) );
		BitmapFont font = generator.generateFont(parameter);
		font.getData().setScale(sizeX*mnX,sizeY*mnY);

		// Dispose resources
		generator.dispose();

		return font;
	}


	private BitmapFont generateFont(String fontName, float sizeX, float sizeY,float w, float h, Color color) {

		String RUSSIAN_CHARACTERS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
				+ "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
				+ "1234567890.,:;_¡¿?\"'+-*/()[]={}<>!"+
				"abcdefghijklmnopqrstuvwxyz" +
				"ABCDEFGHIJGKLMNOPQURSTUVWXYZ";


		// Configure font parameters
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.characters =RUSSIAN_CHARACTERS;
		parameter.size = 24;

		// Generate font
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator( Gdx.files.internal(fontName) );
		BitmapFont font = generator.generateFont(parameter);
		font.getData().setScale(sizeX*mnX,sizeY*mnY);
		font.setColor(color);

		// Dispose resources
		generator.dispose();

		return font;
	}


	private BitmapFont generateFont(String fontName, float sizeX, float sizeY) {

		String RUSSIAN_CHARACTERS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
				+ "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
				+ "1234567890.,:;_¡¿?\"'+-*/()[]={}<>!"+
				"abcdefghijklmnopqrstuvwxyz" +
				"ABCDEFGHIJGKLMNOPQURSTUVWXYZ";


		// Configure font parameters
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.characters =RUSSIAN_CHARACTERS;
		parameter.size = 24;

		// Generate font
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator( Gdx.files.internal(fontName) );
		BitmapFont font = generator.generateFont(parameter);
		font.getData().setScale(sizeX*mnX,sizeY*mnY);

		// Dispose resources
		generator.dispose();

		return font;
	}


	private BitmapFont generateFont(String fontName, float sizeX, float sizeY, Color color) {

		String RUSSIAN_CHARACTERS = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ"
				+ "абвгдеёжзийклмнопрстуфхцчшщъыьэюя"
				+ "1234567890.,:;_¡¿?\"'+-*/()[]={}<>!"+
				"abcdefghijklmnopqrstuvwxyz" +
				"ABCDEFGHIJGKLMNOPQURSTUVWXYZ";


		// Configure font parameters
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.characters =RUSSIAN_CHARACTERS;
		parameter.size = 24;

		// Generate font
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator( Gdx.files.internal(fontName) );
		BitmapFont font = generator.generateFont(parameter);
		font.getData().setScale(sizeX*mnX,sizeY*mnY);
		font.setColor(color);
		// Dispose resources
		generator.dispose();

		return font;
	}



	public static void notification(String str)
	{
		notText = str;
		notTime = 0;
	}

	static String notText="";
	static int notTime = 500;
	static int notMove = 0;
	static Button notif = new Button(97+notMove,17,1258,114);
	public void drawNotification()
	{

		if(notTime<500)notTime++;

		if(notTime<100)
			if(notMove<17+114+10)notMove+=5;
		if(notTime>400)
			if(notMove>0)notMove-=5;

		notif = new Button(97+notMove,17,1258,114);

		drawBox(97,-(17+114)+notMove,1258,114,10);
		drawCentredString(notText,97+(1258/2f),-(17+(114/2f))+notMove,determinationSmol,determinationSmolWidth);
	}

	static String dialogtext = "";
	static boolean dialog = false;
	static String dialmsgY = "";
	static String dialmsgN = "";
	static Button yos;
	static Button nuu;
	static Boolean smolDial = false;
	public static void dialog(String str)
	{
		dialog = true;
		dialogtext = str;
		dialmsgN="OK";
		dialmsgY="OK";

		yos = new Button(534,447,324,128);
		nuu = new Button(534,447,324,128);

	}

	public static void dialog(String str,boolean smol)
	{
		dialog = true;
		dialogtext = str;
		dialmsgN="OK";
		dialmsgY="OK";
		smolDial = smol;
		yos = new Button(534,447,324,128);
		nuu = new Button(534,447,324,128);

	}

	public static void dialog(String str, String yes, String no)
	{
		dialog = true;
		dialogtext = str;

		dialmsgY = yes;
		dialmsgN = no;

		if(dialmsgY.equals(dialmsgN))
		{
			yos = new Button(534,447,324,128);
			nuu = new Button(534,447,324,128);
		}
		else {
			yos = new Button(213, 447, 324, 128);
			nuu = new Button(903, 447, 324, 128);
		}
	}

	public static void proceedDialog(String ans)
	{
		dialog = false;
		dialx=1440/2f;
		switch (ans)
		{
			case "Yes#":
			case "Да#":
				dialog(Graph.res_AREUSURE,Graph.uhum+"##",Graph.nene);
			break;
			case "Yes##":
			case "Да##":
				System.exit(0 );
				break;
		}

	}

	static float dialx=1440/2f;
	public void drawDialogWindow()
	{
		if(dialx>90)dialx-=20;
	drawBox(dialx,60,((1440f/2f)-dialx)*2,587,30);

	if(dialx<=90)
	{
		drawCentredStringSep(dialogtext,1440f/2,142,smolDial?determinationSmol:determinationBigWhite,"\n",((1440f/2f)-dialx)*2,(smolDial?determinationSmolWidth:determinationBigWhiteWidth));
		if(dialmsgY.equals(dialmsgN)) {
			if(yos.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen)
			drawBoxG(534,447,324,128, 10);else
				drawBox(534,447,324,128, 10);
			drawCentredString(dialmsgN,534+324/2f,447+128/2f,determinationBigWhite,determinationBigWhiteWidth);
		}
		else
		{
			if(yos.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen)
				drawBoxG(213,447,324,128, 10);else
			drawBox(213,447,324,128, 10);
			drawCentredString(dialmsgY,213+324/2f,447+128/2f,determinationBigWhite,determinationBigWhiteWidth);
			if(nuu.isPressed(Mistener.tx,Mistener.ty)&&Mistener.onScreen)
				drawBoxG(903,447,324,128, 10);else
			drawBox(903,447,324,128, 10);
			drawCentredString(dialmsgN,903+324/2f,447+128/2f,determinationBigWhite,determinationBigWhiteWidth);
		}
	}

	}

	public void drawBox(float x, float y, float w, float h, float W)
	{
		draw(blackPix,x,y,w,h);
		draw(whitePix,x-W,y,W,h);
		draw(whitePix,x+w,y,W,h);
		draw(whitePix,x-W,y-W,w+W*2,W);
		draw(whitePix,x-W,y+h,w+W*2,W);

	}

	public void drawBoxG(float x, float y, float w, float h, float W)
	{
		draw(grayPix,x,y,w,h);
		draw(whitePix,x-W,y,W,h);
		draw(whitePix,x+w,y,W,h);
		draw(whitePix,x-W,y-W,w+W*2,W);
		draw(whitePix,x-W,y+h,w+W*2,W);

	}


	public static void but_changename()
	{
		selectedStory.stop();
		logoX=144f+52; logoY=314f;logoW=1101f;logoH=98f;
		done = false;
		act=3;
		menuScreenMove=458*2;
		ztm = 0;
		menuAction = 0;
		LmenuAction = 0;
		shine.stop();

		stars = new float[20][2];
		for(int i = 0; i<stars.length;i++)
		{
			stars[i][0]=1440+(1440f/stars.length)*i;
			stars[i][1]=(float)Math.random()*700f;
		}

	}


	public static void setVolume(float MUS, float SFX,boolean is)
	{
		settedvolumeMUS = MUS;
		settedvolumeSFX = SFX;

		prefs.putFloat("volumeMus",MUS);
		prefs.putFloat("volumeSFX",SFX);
		prefs.flush();

		select.setVolume(0,SFX);
		select2.setVolume(0,SFX);
		autorsound.setVolume(0,SFX);

		oggloop.setVolume(MUS);
		intronoice.setVolume(MUS);
		selectedStory.setVolume(MUS);
		enterName.setVolume(MUS);
		shine.setVolume(MUS);

	}

	public static void setVolume(float MUS, float SFX)
	{
		settedvolumeMUS = MUS;
		settedvolumeSFX = SFX;

		select.setVolume(0,SFX);
		select2.setVolume(0,SFX);
		autorsound.setVolume(0,SFX);

		oggloop.setVolume(MUS);
		intronoice.setVolume(MUS);
		selectedStory.setVolume(MUS);
		enterName.setVolume(MUS);
		shine.setVolume(MUS);
		

	}


	public static  void startBattle(String name)
	{
		selectedStory.stop();
		batEnocouter.play();
		act=7;
		x=720-13;
		y=438+13+800+menuScreenMove-153;
	}

	static int playALil=0;
	public static void openBattle(String name)
	{
		isBattleOpen=true;
		batTheme = Gdx.audio.newMusic(Gdx.files.internal("\\sdcard\\UnderBeatsBattles"+name+"\\theme.mp3"));
		FileHandle dta = Gdx.files.internal("\\sdcard\\UnderBeatsBattles\\"+name+"\\data.win");
		String str[] = dta.readString().split("\n");
		musDur = Float.parseFloat(str[0]);
		batTheme.play();
		batTheme.pause();
		//System.out.println("AAAAAAAAAAAAAAAAAAAAa "+str[1].split(",")[0]);
	}



}
