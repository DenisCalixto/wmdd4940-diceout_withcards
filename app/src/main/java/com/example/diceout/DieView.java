package com.example.diceout;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import java.io.IOException;
import java.io.InputStream;

public class DieView extends android.support.v7.widget.AppCompatImageView {

    private int value;
    private Context context;

    public DieView(Context context) {
        super(context);
        init(context);
    }

    public DieView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public DieView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setImageResource(R.drawable.black_joker);
        this.context = context;
    }

    public void roll() {

        String [] faces = {"clubs", "diamonds", "hearts", "spades"};
        String [] cards = {"ace", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "jack", "queen", "king"};

        int face_index = (int) (Math.random() * 4);
        int card_index = (int) (Math.random() * 13);

        value = card_index + 1; //adding one so no card gets value equal to zero
        try {
            InputStream stream = context.getAssets().open(cards[card_index] + "_of_" + faces[face_index] + ".png");
            Drawable d = Drawable.createFromStream(stream,null);
            setImageDrawable(d);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getValue() {
        return value;
    }
}
