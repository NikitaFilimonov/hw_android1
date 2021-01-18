package com.example.hw_android1;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;


public class SecondHW extends AppCompatActivity implements View.OnClickListener, View.OnTouchListener {

    private int openParenthesis = 0;

    private boolean dotUsed = false;

    private boolean equalClicked = false;
    private String lastExpression = "";

    private final static int EXCEPTION = -1;
    private final static int IS_NUMBER = 0;
    private final static int IS_OPERAND = 1;
    private final static int IS_OPEN_PARENTHESIS = 2;
    private final static int IS_CLOSE_PARENTHESIS = 3;
    private final static int IS_DOT = 4;

    Button buttonNumber0;
    Button buttonNumber1;
    Button buttonNumber2;
    Button buttonNumber3;
    Button buttonNumber4;
    Button buttonNumber5;
    Button buttonNumber6;
    Button buttonNumber7;
    Button buttonNumber8;
    Button buttonNumber9;

    Button buttonClear;
    Button buttonBrackets;
    Button buttonPercent;
    Button buttonDivision;
    Button buttonMultiplication;
    Button buttonSubtraction;
    Button buttonAddition;
    Button buttonEqual;
    Button buttonDot;
    Button buttonPlusMinus;

    TextView textViewNumberField;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_h_w);
        initializeViewVariables();
        setOnClickListeners();
        setOnTouchListener();
    }


    private void initializeViewVariables() {
        buttonNumber0 = (Button) findViewById(R.id.button_zero);
        buttonNumber1 = (Button) findViewById(R.id.button_one);
        buttonNumber2 = (Button) findViewById(R.id.button_two);
        buttonNumber3 = (Button) findViewById(R.id.button_three);
        buttonNumber4 = (Button) findViewById(R.id.button_four);
        buttonNumber5 = (Button) findViewById(R.id.button_five);
        buttonNumber6 = (Button) findViewById(R.id.button_six);
        buttonNumber7 = (Button) findViewById(R.id.button_seven);
        buttonNumber8 = (Button) findViewById(R.id.button_eight);
        buttonNumber9 = (Button) findViewById(R.id.button_nine);

        buttonClear = (Button) findViewById(R.id.button_C);
        buttonBrackets = (Button) findViewById(R.id.button_brackets);
        buttonPercent = (Button) findViewById(R.id.button_percent);
        buttonDivision = (Button) findViewById(R.id.button_division);
        buttonMultiplication = (Button) findViewById(R.id.button_multiplication);
        buttonSubtraction = (Button) findViewById(R.id.button_subtraction);
        buttonAddition = (Button) findViewById(R.id.button_addition);
        buttonDot = (Button) findViewById(R.id.button_dot);
        buttonEqual = (Button) findViewById(R.id.button_equal);
        textViewNumberField = (TextView) findViewById(R.id.numberFiled);
    }

    private void setOnClickListeners() {
        buttonNumber0.setOnClickListener(this);
        buttonNumber1.setOnClickListener(this);
        buttonNumber2.setOnClickListener(this);
        buttonNumber3.setOnClickListener(this);
        buttonNumber4.setOnClickListener(this);
        buttonNumber5.setOnClickListener(this);
        buttonNumber6.setOnClickListener(this);
        buttonNumber7.setOnClickListener(this);
        buttonNumber8.setOnClickListener(this);
        buttonNumber9.setOnClickListener(this);

        buttonClear.setOnClickListener(this);
        buttonBrackets.setOnClickListener(this);
        buttonPercent.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonMultiplication.setOnClickListener(this);
        buttonSubtraction.setOnClickListener(this);
        buttonAddition.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
    }

    private void setOnTouchListener() {
        buttonNumber0.setOnTouchListener(this);
        buttonNumber1.setOnTouchListener(this);
        buttonNumber2.setOnTouchListener(this);
        buttonNumber3.setOnTouchListener(this);
        buttonNumber4.setOnTouchListener(this);
        buttonNumber5.setOnTouchListener(this);
        buttonNumber6.setOnTouchListener(this);
        buttonNumber7.setOnTouchListener(this);
        buttonNumber8.setOnTouchListener(this);
        buttonNumber9.setOnTouchListener(this);

        buttonClear.setOnTouchListener(this);
        buttonBrackets.setOnTouchListener(this);
        buttonPercent.setOnTouchListener(this);
        buttonDivision.setOnTouchListener(this);
        buttonMultiplication.setOnTouchListener(this);
        buttonSubtraction.setOnTouchListener(this);
        buttonAddition.setOnTouchListener(this);
        buttonDot.setOnTouchListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_zero:
                if (addNumber("0")) equalClicked = false;
                break;
            case R.id.button_one:
                if (addNumber("1")) equalClicked = false;
                break;
            case R.id.button_two:
                if (addNumber("2")) equalClicked = false;
                break;
            case R.id.button_three:
                if (addNumber("3")) equalClicked = false;
                break;
            case R.id.button_four:
                if (addNumber("4")) equalClicked = false;
                break;
            case R.id.button_five:
                if (addNumber("5")) equalClicked = false;
                break;
            case R.id.button_six:
                if (addNumber("6")) equalClicked = false;
                break;
            case R.id.button_seven:
                if (addNumber("7")) equalClicked = false;
                break;
            case R.id.button_eight:
                if (addNumber("8")) equalClicked = false;
                break;
            case R.id.button_nine:
                if (addNumber("9")) equalClicked = false;
                break;
            case R.id.button_addition:
                if (addOperand("+")) equalClicked = false;
                break;
            case R.id.button_subtraction:
                if (addOperand("-")) equalClicked = false;
                break;
            case R.id.button_multiplication:
                if (addOperand("*")) equalClicked = false;
                break;
            case R.id.button_division:
                if (addOperand("/")) equalClicked = false;
                break;
            case R.id.button_percent:
                if (addOperand("%")) equalClicked = false;
                break;
            case R.id.button_dot:
                if (addDot()) equalClicked = false;
                break;
            case R.id.button_brackets:
                if (addBrackets()) equalClicked = false;
                break;
            case R.id.button_C:
                textViewNumberField.setText("");
                openParenthesis = 0;
                dotUsed = false;
                equalClicked = false;
                break;
            case R.id.button_equal:
                if (textViewNumberField.getText().toString() != null && !textViewNumberField.getText().toString().equals(""))
                    calculate(textViewNumberField.getText().toString());
                break;
        }

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN: {
                view.invalidate();
                break;
            }
            case MotionEvent.ACTION_UP: {
                view.getBackground().clearColorFilter();
                view.invalidate();
                break;
            }
        }
        return false;
    }

    private boolean addDot() {
        boolean done = false;

        if (textViewNumberField.getText().length() == 0) {
            textViewNumberField.setText("0.");
            dotUsed = true;
            done = true;
        } else if (dotUsed == true) {
        } else if (defineLastCharacter(textViewNumberField.getText().charAt(textViewNumberField.getText().length() - 1) + "") == IS_OPERAND) {
            textViewNumberField.setText(textViewNumberField.getText() + "0.");
            done = true;
            dotUsed = true;
        } else if (defineLastCharacter(textViewNumberField.getText().charAt(textViewNumberField.getText().length() - 1) + "") == IS_NUMBER) {
            textViewNumberField.setText(textViewNumberField.getText() + ".");
            done = true;
            dotUsed = true;
        }
        return done;
    }

    private boolean addBrackets() {
        boolean done = false;
        int operationLength = textViewNumberField.getText().length();

        if (operationLength == 0) {
            textViewNumberField.setText(textViewNumberField.getText() + "(");
            dotUsed = false;
            openParenthesis++;
            done = true;
        } else if (openParenthesis > 0 && operationLength > 0) {
            String lastInput = textViewNumberField.getText().charAt(operationLength - 1) + "";
            switch (defineLastCharacter(lastInput)) {
                case IS_NUMBER:
                    textViewNumberField.setText(textViewNumberField.getText() + ")");
                    done = true;
                    openParenthesis--;
                    dotUsed = false;
                    break;
                case IS_OPERAND:
                    textViewNumberField.setText(textViewNumberField.getText() + "(");
                    done = true;
                    openParenthesis++;
                    dotUsed = false;
                    break;
                case IS_OPEN_PARENTHESIS:
                    textViewNumberField.setText(textViewNumberField.getText() + "(");
                    done = true;
                    openParenthesis++;
                    dotUsed = false;
                    break;
                case IS_CLOSE_PARENTHESIS:
                    textViewNumberField.setText(textViewNumberField.getText() + ")");
                    done = true;
                    openParenthesis--;
                    dotUsed = false;
                    break;
            }
        } else if (openParenthesis == 0 && operationLength > 0) {
            String lastInput = textViewNumberField.getText().charAt(operationLength - 1) + "";
            if (defineLastCharacter(lastInput) == IS_OPERAND) {
                textViewNumberField.setText(textViewNumberField.getText() + "(");
                done = true;
                dotUsed = false;
                openParenthesis++;
            } else {
                textViewNumberField.setText(textViewNumberField.getText() + "x(");
                done = true;
                dotUsed = false;
                openParenthesis++;
            }
        }
        return done;
    }

    private boolean addOperand(String operand) {
        boolean done = false;
        int operationLength = textViewNumberField.getText().length();
        if (operationLength > 0) {
            String lastInput = textViewNumberField.getText().charAt(operationLength - 1) + "";

            if ((lastInput.equals("+") || lastInput.equals("-") || lastInput.equals("*") || lastInput.equals("/") || lastInput.equals("%"))) {
                Toast.makeText(getApplicationContext(), "Wrong format", Toast.LENGTH_LONG).show();
            } else if (operand.equals("%") && defineLastCharacter(lastInput) == IS_NUMBER) {
                textViewNumberField.setText(textViewNumberField.getText() + operand);
                dotUsed = false;
                equalClicked = false;
                lastExpression = "";
                done = true;
            } else if (!operand.equals("%")) {
                textViewNumberField.setText(textViewNumberField.getText() + operand);
                dotUsed = false;
                equalClicked = false;
                lastExpression = "";
                done = true;
            }
        } else {
            Toast.makeText(getApplicationContext(), "Wrong Format. Operand Without any numbers?", Toast.LENGTH_LONG).show();
        }
        return done;
    }

    private boolean addNumber(String number) {
        boolean done = false;
        int operationLength = textViewNumberField.getText().length();
        if (operationLength > 0) {
            String lastCharacter = textViewNumberField.getText().charAt(operationLength - 1) + "";
            int lastCharacterState = defineLastCharacter(lastCharacter);

            if (operationLength == 1 && lastCharacterState == IS_NUMBER && lastCharacter.equals("0")) {
                textViewNumberField.setText(number);
                done = true;
            } else if (lastCharacterState == IS_OPEN_PARENTHESIS) {
                textViewNumberField.setText(textViewNumberField.getText() + number);
                done = true;
            } else if (lastCharacterState == IS_CLOSE_PARENTHESIS || lastCharacter.equals("%")) {
                textViewNumberField.setText(textViewNumberField.getText() + "*" + number);
                done = true;
            } else if (lastCharacterState == IS_NUMBER || lastCharacterState == IS_OPERAND || lastCharacterState == IS_DOT) {
                textViewNumberField.setText(textViewNumberField.getText() + number);
                done = true;
            }
        } else {
            textViewNumberField.setText(textViewNumberField.getText() + number);
            done = true;
        }
        return done;
    }

    private void calculate(String input) {
        String result = "";
        try {
            String temp = input;
            if (equalClicked) {
                temp = input + lastExpression;
            } else {
                saveLastExpression(input);
            }
            result = temp.replaceAll("%", "/100");
            BigDecimal decimal = new BigDecimal(result);
            result = decimal.setScale(8, BigDecimal.ROUND_HALF_UP).toPlainString().toString();
            equalClicked = true;

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Wrong Format", Toast.LENGTH_SHORT).show();
            return;
        }

        if (result.equals("Infinity")) {
            Toast.makeText(getApplicationContext(), "Division by zero is not allowed", Toast.LENGTH_SHORT).show();
            textViewNumberField.setText(input);

        } else if (result.contains(".")) {
            result = result.replaceAll(".", "");
            textViewNumberField.setText(result);
        }
    }

    private void saveLastExpression(String input) {
        String lastOfExpression = input.charAt(input.length() - 1) + "";
        if (input.length() > 1) {
            if (lastOfExpression.equals(")")) {
                lastExpression = ")";
                int numberOfCloseParenthesis = 1;

                for (int i = input.length() - 2; i >= 0; i--) {
                    if (numberOfCloseParenthesis > 0) {
                        String last = input.charAt(i) + "";
                        if (last.equals(")")) {
                            numberOfCloseParenthesis++;
                        } else if (last.equals("(")) {
                            numberOfCloseParenthesis--;
                        }
                        lastExpression = last + lastExpression;
                    } else if (defineLastCharacter(input.charAt(i) + "") == IS_OPERAND) {
                        lastExpression = input.charAt(i) + lastExpression;
                        break;
                    } else {
                        lastExpression = "";
                    }
                }
            } else if (defineLastCharacter(lastOfExpression + "") == IS_NUMBER) {
                lastExpression = lastOfExpression;
                for (int i = input.length() - 2; i >= 0; i--) {
                    String last = input.charAt(i) + "";
                    if (defineLastCharacter(last) == IS_NUMBER || defineLastCharacter(last) == IS_DOT) {
                        lastExpression = last + lastExpression;
                    } else if (defineLastCharacter(last) == IS_OPERAND) {
                        lastExpression = last + lastExpression;
                        break;
                    }
                    if (i == 0) {
                        lastExpression = "";
                    }
                }
            }
        }
    }

    private int defineLastCharacter(String lastCharacter) {
        try {
            Integer.parseInt(lastCharacter);
            return IS_NUMBER;
        } catch (NumberFormatException e) {
        }

        if ((lastCharacter.equals("+") || lastCharacter.equals("-") || lastCharacter.equals("*") || lastCharacter.equals("/") || lastCharacter.equals("%")))
            return IS_OPERAND;

        if (lastCharacter.equals("("))
            return IS_OPEN_PARENTHESIS;

        if (lastCharacter.equals(")"))
            return IS_CLOSE_PARENTHESIS;

        if (lastCharacter.equals("."))
            return IS_DOT;

        return -1;
    }

}