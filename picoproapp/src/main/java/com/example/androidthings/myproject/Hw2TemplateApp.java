package com.example.androidthings.myproject;

import android.app.Activity;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

import android.view.View;

import com.google.android.things.pio.Gpio;

/**
 * Template for IDD Fall 2017 HW2 (text entry device)
 * Created by bjoern on 9/5/17.
 */



public class Hw2TemplateApp extends SimplePicoPro {

    enum Mode { alpha, caps, num, sim}
    enum State {start, abcde, fghij, klmno, pqrst, uvwxyz, yz};

    Mode current_mode;
    State current_state;

    float f0,f1,f0_min,f0_max,f1_min,f1_max;
    TextView top_left,top_right,bottom_left,bottom_right,bottom;
    EditText editText;
    //f0 is purple
    //f1 is blue
    //gnd yellow
    //3.3 is green
    boolean flag;

    @Override
    public void setup() {

        // globally
        top_left = (TextView)activity.findViewById(R.id.abcde);
        top_right = (TextView)activity.findViewById(R.id.fghij);
        bottom_left = (TextView)activity.findViewById(R.id.klmno);
        bottom_right = (TextView)activity.findViewById(R.id.pqrst);
        bottom = (TextView)activity.findViewById(R.id.uvwxyz);
        editText = (EditText) activity.findViewById(R.id.editText);

        current_mode = Mode.alpha;
        current_state = State.start;



        flag = false;
        f0_min = .7f;
        f0_max = 3.0f;
        f1_min = .7f;
        f1_max = 3.0f;

        analogInit();

        //set two GPIOs to input
        pinMode(GPIO_128,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_128,Gpio.EDGE_BOTH);

        pinMode(GPIO_39,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_39,Gpio.EDGE_BOTH);

        pinMode(GPIO_37,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_37,Gpio.EDGE_BOTH);

        pinMode(GPIO_35,Gpio.DIRECTION_IN);
        setEdgeTrigger(GPIO_35,Gpio.EDGE_BOTH);
    }

    public float getY(){
        return (f0-f0_min)/(f0_max-f0_min);
    }

    public float getX(){
        return (f1-f1_min)/(f1_max-f1_min);
    }

    void topLeftHit(){
        switch(current_mode){
            case alpha:
                switch (current_state){
                    case start:
                        current_state = State.abcde;
                        break;
                    case abcde:
                        current_state = State.start;
                        printCharacterToScreen('a');
                        break;
                    case fghij:
                        current_state = State.start;
                        printCharacterToScreen('f');
                        break;
                    case klmno:
                        current_state = State.start;
                        printCharacterToScreen('k');
                        break;
                    case pqrst:
                        current_state = State.start;
                        printCharacterToScreen('p');
                        break;
                    case uvwxyz:
                        current_state = State.start;
                        printCharacterToScreen('u');
                        break;
                    case yz:
                        current_state = State.start;
                        break;
                }
                break;
            case caps:
                switch (current_state){
                    case start:
                        current_state = State.abcde;
                        break;
                    case abcde:
                        current_state = State.start;
                        printCharacterToScreen('A');
                        break;
                    case fghij:
                        current_state = State.start;
                        printCharacterToScreen('F');
                        break;
                    case klmno:
                        current_state = State.start;
                        printCharacterToScreen('K');
                        break;
                    case pqrst:
                        current_state = State.start;
                        printCharacterToScreen('P');
                        break;
                    case uvwxyz:
                        current_state = State.start;
                        printCharacterToScreen('U');
                        break;
                    case yz:
                        current_state = State.start;
                        break;
                }
                break;
        }
        setRing(current_mode,current_state);
    }

    void topRightHit(){
        switch(current_mode){
            case alpha:
                switch (current_state){
                    case start:
                        current_state = State.fghij;
                        break;
                    case abcde:
                        current_state = State.start;
                        printCharacterToScreen('b');
                        break;
                    case fghij:
                        current_state = State.start;
                        printCharacterToScreen('g');
                        break;
                    case klmno:
                        current_state = State.start;
                        printCharacterToScreen('l');
                        break;
                    case pqrst:
                        current_state = State.start;
                        printCharacterToScreen('q');
                        break;
                    case uvwxyz:
                        current_state = State.start;
                        printCharacterToScreen('v');
                        break;
                    case yz:
                        current_state = State.start;
                        break;
                }
                break;
            case caps:
                switch (current_state){
                    case start:
                        current_state = State.fghij;
                        break;
                    case abcde:
                        current_state = State.start;
                        printCharacterToScreen('B');
                        break;
                    case fghij:
                        current_state = State.start;
                        printCharacterToScreen('G');
                        break;
                    case klmno:
                        current_state = State.start;
                        printCharacterToScreen('L');
                        break;
                    case pqrst:
                        current_state = State.start;
                        printCharacterToScreen('Q');
                        break;
                    case uvwxyz:
                        current_state = State.start;
                        printCharacterToScreen('V');
                        break;
                    case yz:
                        current_state = State.start;
                        break;
                }
                break;
        }
        setRing(current_mode,current_state);
    }

    void bottomLeftHit(){
        switch(current_mode){
            case alpha:
                switch (current_state){
                    case start:
                        current_state = State.klmno;
                        break;
                    case abcde:
                        current_state = State.start;
                        printCharacterToScreen('c');
                        break;
                    case fghij:
                        current_state = State.start;
                        printCharacterToScreen('h');
                        break;
                    case klmno:
                        current_state = State.start;
                        printCharacterToScreen('m');
                        break;
                    case pqrst:
                        current_state = State.start;
                        printCharacterToScreen('r');
                        break;
                    case uvwxyz:
                        current_state = State.start;
                        printCharacterToScreen('w');
                        break;
                    case yz:
                        current_state = State.start;
                        printCharacterToScreen('y');
                        break;
                }
                break;
            case caps:
                switch (current_state){
                    case start:
                        current_state = State.klmno;
                        break;
                    case abcde:
                        current_state = State.start;
                        printCharacterToScreen('C');
                        break;
                    case fghij:
                        current_state = State.start;
                        printCharacterToScreen('H');
                        break;
                    case klmno:
                        current_state = State.start;
                        printCharacterToScreen('M');
                        break;
                    case pqrst:
                        current_state = State.start;
                        printCharacterToScreen('R');
                        break;
                    case uvwxyz:
                        current_state = State.start;
                        printCharacterToScreen('W');
                        break;
                    case yz:
                        current_state = State.start;
                        printCharacterToScreen('Y');
                        break;
                }
                break;
        }
        setRing(current_mode,current_state);
    }

    void bottomRightHit(){
        switch(current_mode){
            case alpha:
                switch (current_state){
                    case start:
                        current_state = State.pqrst;
                        break;
                    case abcde:
                        current_state = State.start;
                        printCharacterToScreen('d');
                        break;
                    case fghij:
                        current_state = State.start;
                        printCharacterToScreen('i');
                        break;
                    case klmno:
                        current_state = State.start;
                        printCharacterToScreen('n');
                        break;
                    case pqrst:
                        current_state = State.start;
                        printCharacterToScreen('s');
                        break;
                    case uvwxyz:
                        current_state = State.start;
                        printCharacterToScreen('x');
                        break;
                    case yz:
                        current_state = State.start;
                        printCharacterToScreen('z');
                        break;
                }
                break;
            case caps:
                switch (current_state){
                    case start:
                        current_state = State.pqrst;
                        break;
                    case abcde:
                        current_state = State.start;
                        printCharacterToScreen('D');
                        break;
                    case fghij:
                        current_state = State.start;
                        printCharacterToScreen('I');
                        break;
                    case klmno:
                        current_state = State.start;
                        printCharacterToScreen('N');
                        break;
                    case pqrst:
                        current_state = State.start;
                        printCharacterToScreen('S');
                        break;
                    case uvwxyz:
                        current_state = State.start;
                        printCharacterToScreen('X');
                        break;
                    case yz:
                        current_state = State.start;
                        printCharacterToScreen('Z');
                        break;
                }
                break;
        }
        setRing(current_mode,current_state);
    }

    void bottomHit(){
        switch(current_mode){
            case alpha:
                switch (current_state){
                    case start:
                        current_state = State.uvwxyz;
                        break;
                    case abcde:
                        current_state = State.start;
                        printCharacterToScreen('e');
                        break;
                    case fghij:
                        current_state = State.start;
                        printCharacterToScreen('j');
                        break;
                    case klmno:
                        current_state = State.start;
                        printCharacterToScreen('o');
                        break;
                    case pqrst:
                        current_state = State.start;
                        printCharacterToScreen('t');
                        break;
                    case uvwxyz:
                        current_state = State.yz;
                        break;
                    case yz:
                        current_state = State.start;
                        break;
                }
                break;
            case caps:
                switch (current_state){
                    case start:
                        current_state = State.abcde;
                        break;
                    case abcde:
                        current_state = State.start;
                        printCharacterToScreen('E');
                        break;
                    case fghij:
                        current_state = State.start;
                        printCharacterToScreen('J');
                        break;
                    case klmno:
                        current_state = State.start;
                        printCharacterToScreen('O');
                        break;
                    case pqrst:
                        current_state = State.start;
                        printCharacterToScreen('T');
                        break;
                    case uvwxyz:
                        current_state = State.yz;
                        break;
                    case yz:
                        current_state = State.start;
                        break;
                }
                break;
        }
        setRing(current_mode,current_state);
    }


    void setRing(Mode mode, State state){
        switch(mode) {
            case alpha:
                switch (state) {
                    case start:
                        top_left.setText("abcde");
                        top_right.setText("fghij");
                        bottom_left.setText("klmno");
                        bottom_right.setText("pqrst");
                        bottom.setText("uvwxyz");
                        break;
                    case abcde:
                        top_left.setText("a");
                        top_right.setText("b");
                        bottom_left.setText("c");
                        bottom_right.setText("d");
                        bottom.setText("e");
                        break;
                    case fghij:
                        top_left.setText("f");
                        top_right.setText("g");
                        bottom_left.setText("h");
                        bottom_right.setText("i");
                        bottom.setText("j");
                        break;
                    case klmno:
                        top_left.setText("k");
                        top_right.setText("l");
                        bottom_left.setText("m");
                        bottom_right.setText("n");
                        bottom.setText("o");
                        break;
                    case pqrst:
                        top_left.setText("p");
                        top_right.setText("q");
                        bottom_left.setText("r");
                        bottom_right.setText("s");
                        bottom.setText("t");
                        break;
                    case uvwxyz:
                        top_left.setText("u");
                        top_right.setText("v");
                        bottom_left.setText("w");
                        bottom_right.setText("x");
                        bottom.setText("yz");
                        break;
                    case yz:
                        top_left.setText("");
                        top_right.setText("");
                        bottom_left.setText("y");
                        bottom_right.setText("z");
                        bottom.setText("");
                        break;
                }
                break;
            case caps:
                switch (state) {
                    case start:
                        top_left.setText("ABCDE");
                        top_right.setText("FGHIJ");
                        bottom_left.setText("KLMNO");
                        bottom_right.setText("PQRST");
                        bottom.setText("UVWXYZ");
                        break;
                    case abcde:
                        top_left.setText("A");
                        top_right.setText("B");
                        bottom_left.setText("C");
                        bottom_right.setText("D");
                        bottom.setText("E");
                        break;
                    case fghij:
                        top_left.setText("F");
                        top_right.setText("G");
                        bottom_left.setText("H");
                        bottom_right.setText("I");
                        bottom.setText("J");
                        break;
                    case klmno:
                        top_left.setText("K");
                        top_right.setText("L");
                        bottom_left.setText("M");
                        bottom_right.setText("N");
                        bottom.setText("O");
                        break;
                    case pqrst:
                        top_left.setText("P");
                        top_right.setText("Q");
                        bottom_left.setText("R");
                        bottom_right.setText("S");
                        bottom.setText("T");
                        break;
                    case uvwxyz:
                        top_left.setText("U");
                        top_right.setText("V");
                        bottom_left.setText("W");
                        bottom_right.setText("X");
                        bottom.setText("YZ");
                        break;
                    case yz:
                        top_left.setText("");
                        top_right.setText("");
                        bottom_left.setText("Y");
                        bottom_right.setText("Z");
                        bottom.setText("");
                        break;
                }
                break;
            case num:
                break;
            case sim:
                break;

        }
    }

    @Override
    public void loop() {
        f0=analogRead(A0);
        f1=analogRead(A1);

        float x = getX();
        float y = getY();
        //println("X: "+Float.toString(x));
        //println("Y: "+Float.toString(y));

        if(x<.4f && y <.4f && flag == false){
            //printCharacterToScreen('e');
            topLeftHit();
            flag = true;
        }
        if(x<.4f && y >.6f && flag == false){
            bottomLeftHit();
            flag = true;
        }
        if(x>.6f && y <.4f && flag == false){
            topRightHit();
            flag = true;
        }
        if(x>.6f && y >.6f && flag == false){
            bottomRightHit();
            flag = true;
        }
        if(x>.4 && x<.6 && y>.6 && flag==false){
            bottomHit();
            flag = true;
        }
        if(x>.4 && x<.6 && y>.4 && y<.6){
            flag = false;
        }
        delay(3);



    }

    @Override
    void digitalEdgeEvent(Gpio pin, boolean value) {
        println("digitalEdgeEvent"+pin+", "+value);
        // when 128 goes from LOW to HIGH
        // this is on button button release for pull-up resistors
        if(pin==GPIO_128 && value==HIGH) {
            if(current_state!=State.start){
                current_state=State.start;
            }else{
                switch (current_mode){
                    case alpha:
                        current_mode=Mode.caps;
                        break;
                    case caps:
                        current_mode=Mode.alpha;
                        break;
                }
            }
            setRing(current_mode, current_state);
        }
        //when 39 goes from HIGH to HIGH
        else if (pin==GPIO_39 && value==HIGH) {
            if(current_state!=State.start){
                current_state=State.start;
                setRing(current_mode, current_state);
            }else {
                printCharacterToScreen('\n');
            }
        }
        //when 37 goes from HIGH to HIGH
        else if (pin==GPIO_37 && value==HIGH) {
            //printCharacterToScreen('\u232b');
            if(current_state!=State.start){
                current_state=State.start;
                setRing(current_mode, current_state);
            }else {
                editText.dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
            }
        }
        //when 35 goes from HIGH to HIGH
        else if (pin==GPIO_35 && value==HIGH) {
            if(current_state!=State.start){
                current_state=State.start;
                setRing(current_mode, current_state);
            }else {
                printCharacterToScreen(' ');
            }
        }
    }
}
