package pl.akademiakodu;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.util.List;

import java.util.Scanner;

public class Main extends JFrame implements ActionListener
{

    private JButton buttonYes;
    private JButton buttonNo;
    private JLabel labelQuestion;
    private int currentQuestion;
    private int numberOfPoints = 0;
    //zmienna która jest  typu interfejsowego
    // co oznacza że musi to tej zmiennej przekazać klasę
    //Mowimy ogólnie o typie a nie mowi konkretnie o klasie
    //podajemy kategorie, do której będzie należeć klasa


    //Lista pytań
    private QuestionGenerator
            questionGenerator;
    private List<Question> questionList = new ArrayList<>();

    public void setQuestionGenerator(QuestionGenerator questionGenerator) {
        //ustawiamy zmienną z 21 linijki na tą ktora jest podana w argumencie metody
        this.questionGenerator = questionGenerator;
        //tutaj zakladamy że już mamy obiekt jakiejś klasy
        //na etapie pisania kodu nie wiemy kompletnie jaka to będzie klasa
        //tylko wiemy że musi implementować interfejs QuestionGenerator
        //wypełniamy listę pytaniami, które są generowane za pomocą metody generateQuestions
        questionList = questionGenerator.generateQuestions();
    }
    // ma zawierać pytanie
    // ma zawierać 2 przycisku tak i nie

    public Main() {

        super("Milionerzy"); // ustawia tytuł okno
        setSize(500, 500);   // ustawia wielkość okna
        setDefaultCloseOperation(1); // sprawia ,że działa przycisk exit

        setVisible(true); //
        setQuestionGenerator(new SimpleQuestionGenerator());
        //Ustawiamy konkretną klasę, która będzie nam generować pytania
        //za pomocą new NazwaKlasy możemy podmienić nasz generator za pomocą 1 linijki kodu
        buttonYes = new JButton("Tak"); //tworzymy button z napisem tak
        buttonNo = new JButton("Nie"); //tworzymy button z napisem nie
        buttonYes.addActionListener((ActionListener) this);
        //this wskazuje na objekt w którym jest
        //na rzecz którego w tym momencie wywoływany jest konstruktor
        //Listen ma być obiekt main czyli okno
        buttonNo.addActionListener((ActionListener) this);

        labelQuestion = new JLabel("Czy Polska leży w Europie>", 0);
        add(labelQuestion);     //Metoda dodajemy do frame naszą label
        add(buttonYes);         //metoda dodajemy do frame nasz przycisk
        add(buttonNo);          //metoda dodajemy przycisk nie

//układ naszego okna 3 w pionie 1 w poziomie
        setLayout(new GridLayout(3, 1)); // 3 rzędy i w każdym 1 element
    }
    public static void main(String[] args) {
//odpalenie okna w wątku
        SwingUtilities.invokeLater(new Runnable() {        // odpowiada za to czy nam zrobi runa

            @Override
            public void run() {
                new Main();
            }
        });
    }
//Ta metoda jest wywołana gdy klikniemy na przycisk - klikneliśmy na label i alt +enter

    @Override
    public void actionPerformed(ActionEvent e) {
        //kolejne pytanie musi się mieścić w liście
        if (currentQuestion <questionList.size()) {
            JButton clickedButton =(JButton) e.getSource();
           Question currentQuestion = questionList.get(this.currentQuestion);
            if (clickedButton == buttonYes && currentQuestion.isCorrect()
                 numberOfPoints++;
            if (clickedButton == buttonNo && currentQuestion.isCorrect())
            {
                numberOfPoints++;
            }
        }

        if (currentQuestion + 1 < questionList.size()) {
            labelQuestion.setText(questionList.get(++currentQuestion).getContent());
        } else {
            JOptionPane.showMessageDialog(this, "Koniec quizu zdobyłeś" + numberOfPoints + " punkty");
            buttonNo.setEnabled(false);
            buttonYes.setEnabled(false);
        }

    }