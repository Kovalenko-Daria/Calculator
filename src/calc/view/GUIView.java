package calc.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.RoundRectangle2D;
import java.math.BigDecimal;
import java.util.ArrayList;

import calc.controller.*;
import calc.model.*;

public class GUIView {
    private final JFrame window;
    private final JTextField expressionField;
    private final JCalculatorButtonPanel calcButtons;
    private final static int WIDTH = 300;
    private final static int HEIGHT = 300;
    private final Calculator calculator;
    private final ExpressionParse expressionParse;
    private final CalculateExpression calculateExpression;

    {
        window = new JFrame("Daria Custom Calculator");
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(WIDTH, HEIGHT);
        window.setResizable(false);

        expressionField = new JTextField();
        expressionField.setPreferredSize(new Dimension(WIDTH, 40));
        expressionField.setFont(new Font("Lucida Grande", Font.PLAIN,18));
        expressionField.setEditable(false);
        expressionField.setFocusable(false);
        calcButtons = new JCalculatorButtonPanel();
        window.add(expressionField, BorderLayout.NORTH);
        window.add(calcButtons, BorderLayout.CENTER);

        calculator = new Calculator();
        expressionParse = new ExpressionParse();
        calculateExpression = new CalculateExpression();
    }

    private class JCalculatorButtonPanel extends JPanel {
        private final static Color colorOperation = new Color(255, 227, 255);
        private final static Color colorCalc = new Color(224, 31, 224);
        private final static Color textColorCalc = new Color(255, 255, 255);
        private final static Color textColorOperation = new Color(0, 0, 0);

        {
            drawButtons();
        }

        private void drawButtons() {
            GridLayout layout = new GridLayout(5, 4);
            this.setLayout(layout);
            JButtonActionTap buttonOpen = new JButtonActionTap("(", colorOperation, textColorOperation);
            buttonOpen.addActionListener(new ButtonInputListener());
            JButtonActionTap buttonClose = new JButtonActionTap(")", colorOperation, textColorOperation);
            buttonClose.addActionListener(new ButtonInputListener());
            JButtonActionTap buttonAllClear = new JButtonActionTap("AC", colorCalc, textColorCalc);
            buttonAllClear.addActionListener(new ButtonAllClearListener());
            JButtonActionTap buttonCalc = new JButtonActionTap("=", colorCalc, textColorCalc);
            buttonCalc.addActionListener(new ButtonCalcListener());
            JButton buttonClearEntry = new JButtonActionTap("CE", colorOperation, textColorOperation);
            buttonClearEntry.addActionListener(new ButtonClearEntryListener());
            JButton buttonAddition = new JButton("+");
            buttonAddition.addActionListener(new ButtonInputListener());
            JButton buttonSubstraction = new JButton("-");
            buttonSubstraction.addActionListener(new ButtonInputListener());
            JButton buttonMultiplication = new JButton("*");
            buttonMultiplication.addActionListener(new ButtonInputListener());
            JButton buttonDivision = new JButton("/");
            buttonDivision.addActionListener(new ButtonInputListener());
            JButton buttonSeparator = new JButton(".");
            buttonSeparator.addActionListener(new ButtonInputListener());
            JButton button0 = new JButton("0");
            button0.addActionListener(new ButtonInputListener());
            JButton button1 = new JButton("1");
            button1.addActionListener(new ButtonInputListener());
            JButton button2 = new JButton("2");
            button2.addActionListener(new ButtonInputListener());
            JButton button3 = new JButton("3");
            button3.addActionListener(new ButtonInputListener());
            JButton button4 = new JButton("4");
            button4.addActionListener(new ButtonInputListener());
            JButton button5 = new JButton("5");
            button5.addActionListener(new ButtonInputListener());
            JButton button6 = new JButton("6");
            button6.addActionListener(new ButtonInputListener());
            JButton button7 = new JButton("7");
            button7.addActionListener(new ButtonInputListener());
            JButton button8 = new JButton("8");
            button8.addActionListener(new ButtonInputListener());
            JButton button9 = new JButton("9");
            button9.addActionListener(new ButtonInputListener());

            this.add(buttonOpen);
            this.add(buttonClose);
            this.add(buttonAllClear);
            this.add(buttonClearEntry);
            this.add(button7);
            this.add(button8);
            this.add(button9);
            this.add(buttonAddition);
            this.add(button4);
            this.add(button5);
            this.add(button6);
            this.add(buttonSubstraction);
            this.add(button1);
            this.add(button2);
            this.add(button3);
            this.add(buttonMultiplication);
            this.add(button0);
            this.add(buttonSeparator);
            this.add(buttonCalc);
            this.add(buttonDivision);
        }

        private class JButtonActionTap extends JButton {
            private final Color backgroundColor;
            private static final int ARC_WIDTH = 20;
            private static final int ARC_HEIGHT = 20;

            JButtonActionTap(String text, Color backgroundColor, Color foregroundColor) {
                super(text);
                this.backgroundColor = backgroundColor;
                this.setForeground(foregroundColor);
                setOpaque(false);
                setContentAreaFilled(false);
                setBorderPainted(false);
                setFocusPainted(false);
                setMargin(new Insets(0, 0, 0, 0));
            }

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Определяем цвет фона
                Color color = backgroundColor;

                // Рисуем закруглённый прямоугольник
                g2.setColor(color);
                g2.fill(new RoundRectangle2D.Float(0, 0, getWidth() - 3, getHeight() - 3, ARC_WIDTH, ARC_HEIGHT));
                // Рисуем текст по центру
                super.paintComponent(g2);
                g2.dispose();
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.draw(new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), ARC_WIDTH, ARC_HEIGHT));
                g2.dispose();
            }

            @Override
            public boolean contains(int x, int y) {
                // Чтобы клик работал только внутри закруглённой области
                return new RoundRectangle2D.Float(0, 0, getWidth(), getHeight(), ARC_WIDTH, ARC_HEIGHT)
                        .contains(x, y);
            }
        }

        private class ButtonAllClearListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                expressionField.setText("");
            }
        }

        private class ButtonClearEntryListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expression = expressionField.getText();
                if (!expression.isEmpty()) {
                    expressionField.setText(expression.substring(0, expression.length() - 1));
                }
            }
        }

        private class ButtonInputListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonText = ((JButton) e.getSource()).getText();
                expressionField.setText(expressionField.getText() + buttonText);
            }
        }

        private class ButtonCalcListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String expressionString = expressionField.getText();
                try {
                    Expression expression = expressionParse.parseExpression(expressionString);
                    BigDecimal result = calculateExpression.calculateExpression(expression);
                    CalculatedAnswer answer = new CalculatedAnswer(expression, result);
                    expressionField.setText(result.toPlainString());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Ошибка\n" + ex.getMessage());
                }
            }
        }
    }

    public void start() {
        window.setVisible(true);
    }
}
