package com.mycompany.mug3n;

import java.net.URISyntaxException;
import java.net.URL;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {
    //scene
    int sceneX = 700;
    int sceneY = 392;
    //variables de vida
    int hpGon = 150;
    int hpKillua = 150;
    int hpbKillua = 300;
    int hpbGon = 300;
    //posiciones
    int posKilluaX = 100;
    int posKilluaY = 250;
    int posGonX = 550;
    int posGonY = 260;
    int bigKX = 3;
    int bigKY = 3;
    int bigGX = 3;
    int bigGY = 3;
    
    //velocidad de movimiento
    int movspeedKillua = 0;
    int movspeedKilluaY = 0;
    int movspeedGonY = 0;
    int movspeedGon = 0;
    //ints para atk y def
    int atkKillua = 15;
    int atkGon = 15;
    int defKillua = 0;
    int defGon = 0;
    
    //movimientos de killua
    boolean pulsW = false; //salto
    boolean pulsA = false; //izquierda
    boolean pulsD = false; //derecha
    boolean pulsE = false; //ataque
    boolean pulsQ = false; //defensa
    //movimientos de gon
    boolean pulsAR = false;//salto
    boolean pulsIZQ = false;//izquierda
    boolean pulsDER = false;//derecha
    boolean pulsO = false;//ataque
    boolean pulsP = false;//defensa
    
    //Quien gana
    boolean ganaKillua = false;
    boolean ganaGon = false;
    
    //Muere
    boolean muereKillua = false;
    boolean muereGon = false;
    
    @Override
    public void start(Stage stage) {
        //Elementos de la pantalla
        Pane root = new Pane();
        Scene scene = new Scene(root,sceneX,sceneY);
        stage.setTitle("Mugen");    
        stage.setScene (scene);
        stage.show();
        //Fondo de pantalla
        Image img = new Image(getClass().getResourceAsStream("/images/Desierto_Goldo.png"));
        ImageView imgView = new ImageView(img);
        root.getChildren().add(imgView);
        //Añadir personajes
        Image killua = new Image(getClass().getResourceAsStream("/images/Killua quieto.png"));
        ImageView killuaView = new ImageView(killua);
        killuaView.setScaleX(bigKX);
        killuaView.setScaleY(bigKY);
        killuaView.setX(posKilluaX);
        killuaView.setY(posKilluaY);
        root.getChildren().add(killuaView);
        
        Image gon = new Image(getClass().getResourceAsStream("/images/Gon quieto.png"));
        ImageView gonView = new ImageView(gon);
        gonView.setScaleX(bigGX);
        gonView.setScaleY(bigGY);
        gonView.setX(posGonX);
        gonView.setY(posGonY);
        root.getChildren().add(gonView);
        
        Rectangle bordehpk = new Rectangle (310,30,Color.BLACK);
        bordehpk.setX(15);
        bordehpk.setY(15);
        root.getChildren().add(bordehpk);
        Rectangle hpkillua = new Rectangle (hpbKillua,20,Color.ORANGE);
        hpkillua.setX(20);
        hpkillua.setY(20);
        root.getChildren().add(hpkillua);
        
        Rectangle bordehpg = new Rectangle (310,30,Color.BLACK);
        bordehpg.setX(375);
        bordehpg.setY(15);
        root.getChildren().add(bordehpg);
        Rectangle hpgon = new Rectangle (hpbGon,20,Color.ORANGE);
        hpgon.setX(380);
        hpgon.setY(20);
        root.getChildren().add(hpgon);
        
        //Image killuacorriendo1 = new Image(getClass().getResourceAsStream("/images/Sprite killua corriendo-1.png"));
        //Image killuacorriendo2 = new Image(getClass().getResourceAsStream("/images/Sprite killua corriendo-2.png"));
        //Image killuacorriendo3 = new Image(getClass().getResourceAsStream("/images/Sprite killua corriendo-3.png"));
        //Image killuacorriendo4 = new Image(getClass().getResourceAsStream("/images/Sprite killua corriendo-4.png"));
        //Image killuacorriendo5 = new Image(getClass().getResourceAsStream("/images/Sprite killua corriendo-5.png"));
        //Image killuacorriendo6 = new Image(getClass().getResourceAsStream("/images/Sprite killua corriendo-6.png"));
        //Image goncubriendose1 = new Image(getClass().getResourceAsStream("/images/Sprite gon cubriendose-1.png"));
        //Image goncubriendose2 = new Image(getClass().getResourceAsStream("/images/Sprite gon cubriendose-2.png"));
        //Image gonsaltando1 = new Image(getClass().getResourceAsStream("/images/Sprite gon saltando-1.png"));
        //Image gonsaltando2 = new Image(getClass().getResourceAsStream("/images/Sprite gon saltando-2.png"));
        //Image gonsaltando3 = new Image(getClass().getResourceAsStream("/images/Sprite gon saltando-3.png"));
        //Image gonsaltando4 = new Image(getClass().getResourceAsStream("/images/Sprite gon saltando-4.png"));
        //Image gonsaltando5 = new Image(getClass().getResourceAsStream("/images/Sprite gon saltando-5.png"));
        //Image killuaatacando = new Image(getClass().getResourceAsStream("/images/Sprite killua atancando.png"));
        //Image killuacubriendose1 = new Image(getClass().getResourceAsStream("/images/Sprite killua cubriendose-1.png"));
        //Image killuacubriendose2 = new Image(getClass().getResourceAsStream("/images/Sprite killua cubriendose-2.png"));
        //Image killuasalto1 = new Image(getClass().getResourceAsStream("/images/Sprite killua salto-1.png"));
        //Image killuasalto2 = new Image(getClass().getResourceAsStream("/images/Sprite killua salto-2.png"));
        //Image killuasalto3 = new Image(getClass().getResourceAsStream("/images/Sprite killua salto-3.png"));
        //Image killuasalto4 = new Image(getClass().getResourceAsStream("/images/Sprite killua salto-4.png"));
        //Image gonatacando = new Image(getClass().getResourceAsStream("/images/Sprite gon atacando.png"));
        //Image gonatacando = new Image(getClass().getResourceAsStream("/images/gon transformación.gif"));
        
        //ImageView animacion = new ImageView(gonatacando);
        //root.getChildren().add(animacion);
        
        //ImageView endanim = new ImageView(killuacorriendo6);
        //root.getChildren().add(endanim);
        
        //audio
        URL urlAudio = getClass().getResource("/sound/Hunter X Hunter 2011 OST - Hisoka Theme [extended].mp3");
        if(urlAudio != null) {
            try {
                AudioClip HisokaOST = new AudioClip(urlAudio.toURI().toString());
                HisokaOST.play();
            } catch (URISyntaxException ex) {
                System.out.println("Error en el formato de ruta de archivo de audio");
            }
        } else {
            System.out.println("No se ha encontrado el archivo de audio");
        }
        
        //movimiento de los personajes
        Timeline pelea = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                posKilluaX += movspeedKillua;
                if(posKilluaX < 10) {
                    posKilluaX = 10;
                }
                if(posKilluaX > 650) {
                    posKilluaX = 650;
                }
                killuaView.setX(posKilluaX);
                
                posKilluaY += movspeedKilluaY;
                if(posKilluaY < 200) {
                    posKilluaY = 200;       
                }
                
                killuaView.setY(posKilluaY);
                
                posGonX += movspeedGon;
                if(posGonX < 10) {
                    posGonX = 10;
                }   
                if(posGonX > 635) {
                    posGonX = 635;
                }
                gonView.setX(posGonX);
                             
                posGonY += movspeedGonY;
                if(posGonY < 205) { 
                    posGonY = 205;
                }
                gonView.setY(posGonY);
                
            })
        );
        pelea.setCycleCount(Timeline.INDEFINITE);
        pelea.play();
        
        scene.setOnKeyPressed((KeyEvent event) -> {
            switch(event.getCode()){
                case W:
                    movspeedKilluaY = -5;
                    break;
                case A:
                    movspeedKillua = -5;
                    break;
                case D:
                    movspeedKillua = 5;
                    break;  
                case UP:
                    movspeedGonY = -5;
                    break;
                case LEFT:
                    movspeedGon = -5;
                    break;
                case RIGHT:
                    movspeedGon = 5;
                    break;  
            }
        });
        scene.setOnKeyReleased((KeyEvent event)->{
            movspeedKillua = 0;
            movspeedGon = 0;
        });
        
   
        
    }
    public static void main(String[] args) {
        launch();
    }



}