package com.example.android.howwelldoyouknowme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name_field;
    CheckBox indonesian_food;
    CheckBox junk_food;
    CheckBox japanese_food;
    CheckBox novel;
    CheckBox biography;
    CheckBox self_help;
    RadioButton question_three_a;
    RadioButton question_three_b;
    RadioButton question_three_c;
    RadioButton sleep;
    RadioButton netflix;
    RadioButton code;

    protected int numberOfCheckboxesCheckedOne = 0;
    protected int numberOfCheckboxesCheckedTwo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_field = findViewById(R.id.name_field);
        indonesian_food = findViewById(R.id.indonesian_food);
        junk_food = findViewById(R.id.junk_food);
        japanese_food = findViewById(R.id.japanese_food);
        novel = findViewById(R.id.novel);
        biography = findViewById(R.id.biography);
        self_help = findViewById(R.id.self_help);
        question_three_a = findViewById(R.id.question_three_a);
        question_three_b = findViewById(R.id.question_three_b);
        question_three_c = findViewById(R.id.question_three_c);
        sleep = findViewById(R.id.sleep);
        netflix = findViewById(R.id.netflix);
        code = findViewById(R.id.code);

        indonesian_food.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (numberOfCheckboxesCheckedOne == 2 && b) {
                    cb.setChecked(false);
                    Toast.makeText(getApplicationContext(),
                            "Limit reached!!!", Toast.LENGTH_SHORT).show();
                } else if (b) {
                    numberOfCheckboxesCheckedOne++;
                } else if (!b) {
                    numberOfCheckboxesCheckedOne--;
                }
            }
        });

        junk_food.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (numberOfCheckboxesCheckedOne == 2 && b) {
                    cb.setChecked(false);
                    Toast.makeText(getApplicationContext(),
                            "Limit reached!!!", Toast.LENGTH_SHORT).show();
                } else if (b) {
                    numberOfCheckboxesCheckedOne++;
                } else if (!b) {
                    numberOfCheckboxesCheckedOne--;
                }
            }
        });

        japanese_food.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (numberOfCheckboxesCheckedOne == 2 && b) {
                    cb.setChecked(false);
                    Toast.makeText(getApplicationContext(),
                            "Limit reached!!!", Toast.LENGTH_SHORT).show();
                } else if (b) {
                    numberOfCheckboxesCheckedOne++;
                } else if (!b) {
                    numberOfCheckboxesCheckedOne--;
                }
            }
        });

        novel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (numberOfCheckboxesCheckedTwo == 2 && b) {
                    cb.setChecked(false);
                    Toast.makeText(getApplicationContext(),
                            "Limit reached!!!", Toast.LENGTH_SHORT).show();
                } else if (b) {
                    numberOfCheckboxesCheckedTwo++;
                } else if (!b) {
                    numberOfCheckboxesCheckedTwo--;
                }
            }
        });

        biography.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (numberOfCheckboxesCheckedTwo == 2 && b) {
                    cb.setChecked(false);
                    Toast.makeText(getApplicationContext(),
                            "Limit reached!!!", Toast.LENGTH_SHORT).show();
                } else if (b) {
                    numberOfCheckboxesCheckedTwo++;
                } else if (!b) {
                    numberOfCheckboxesCheckedTwo--;
                }
            }
        });

        self_help.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (numberOfCheckboxesCheckedTwo == 2 && b) {
                    cb.setChecked(false);
                    Toast.makeText(getApplicationContext(),
                            "Limit reached!!!", Toast.LENGTH_SHORT).show();
                } else if (b) {
                    numberOfCheckboxesCheckedTwo++;
                } else if (!b) {
                    numberOfCheckboxesCheckedTwo--;
                }
            }
        });

    }


    public void calculateScore(View view) {

        EditText nameField = name_field;
        Editable nameEditable = nameField.getText();
        String name = nameEditable.toString();

        boolean likesIndonesianFood = indonesian_food.isChecked();
        boolean likesJunkFood = junk_food.isChecked();
        boolean likesJapaneseFood = japanese_food.isChecked();
        boolean likesQuestionThreeA = question_three_a.isChecked();
        boolean likesQuestionThreeB = question_three_b.isChecked();
        boolean likesQuestionThreeC = question_three_c.isChecked();
        boolean likesNovel = novel.isChecked();
        boolean likesBiography = biography.isChecked();
        boolean likesSelfHelp = self_help.isChecked();
        boolean likesSleep = sleep.isChecked();
        boolean likesNetflix = netflix.isChecked();
        boolean likesCode = code.isChecked();

        int score = showFinalScore(likesIndonesianFood, likesJunkFood, likesJapaneseFood, likesNovel, likesBiography, likesSelfHelp, likesQuestionThreeA, likesQuestionThreeB, likesQuestionThreeC, likesSleep, likesNetflix, likesCode);

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, name + "'s score is " + score + "/8!");
        intent.setType(getString(R.string.plain));
        startActivity(intent);
    }

    private int showFinalScore(boolean addIndonesianFood, boolean addJunkFood, boolean addJapaneseFood, boolean chooseNovel, boolean chooseBiography, boolean chooseSelfHelp, boolean chooseQuestionA, boolean chooseQuestionB, boolean chooseQuestionC, boolean chooseSleep, boolean chooseNetflix, boolean chooseCode) {

        int score = 0;

        if (addIndonesianFood) {
            score = score + 1;
        }

        if (addJunkFood) {
            score = score + 0;
        }

        if (addJapaneseFood) {
            score = score + 1;
        }

        if (chooseNovel) {
            score = score + 0;
        }

        if (chooseBiography) {
            score = score + 1;
        }

        if (chooseSelfHelp) {
            score = score + 1;
        }

        if (chooseQuestionA) {
            score = score + 0;
        }

        if (chooseQuestionB) {
            score = score + 2;
        }

        if (chooseQuestionC) {
            score = score + 0;
        }

        if (chooseSleep) {
            score = score + 0;
        }

        if (chooseNetflix) {
            score = score + 0;
        }

        if (chooseCode) {
            score = score + 2;
        }

        return score;
    }
}