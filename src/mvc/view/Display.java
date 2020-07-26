package mvc.view;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;
import components.Components;
import mvc.controller.Controller;
import mvc.model.Model;
import observer.observers.Observer;

import java.awt.event.MouseEvent;

public class Display extends GraphicsProgram implements Observer, View {

    private final Controller controller;
    private final Model model;

    private Button clickButton;
    private GLabel counter;
    private GLabel keyboardLayout;
    private GLabel systemVersion;
    private GLabel time;
    private GLabel timer;

    public Display(Controller controller, Model model) {
        this.controller = controller;
        this.model = model;
        model.addObserver(this);
        this.createElements();
        this.addMouseListeners();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (clickButton.contains(e.getX(), e.getY()))
            controller.updateButtonClicked();
    }

    @Override
    public void update() {
        counter.setLabel(model.getInformation(Components.COUNTER));
        keyboardLayout.setLabel(model.getInformation(Components.LAYOUT));
        systemVersion.setLabel(model.getInformation(Components.SYSTEM_VERSION));
        time.setLabel(model.getInformation(Components.TIME));
        timer.setLabel(model.getInformation(Components.TIMER));
    }

    private void createElements() {
        createButtons();
        createLabels();
    }

    private void createButtons() {
        clickButton = new Button("Click me", (double) getWidth() / 3, (double) getHeight() / 2);
    }

    private void createLabels() {
        counter = new GLabel(model.getInformation(Components.COUNTER), (double) getWidth() / 2, (double) getHeight() * 1 / 6);
        keyboardLayout = new GLabel(model.getInformation(Components.LAYOUT), (double) getWidth() / 2, (double) getHeight() * 2 / 6);
        systemVersion = new GLabel(model.getInformation(Components.SYSTEM_VERSION), (double) getWidth() / 2, (double) getHeight() * 3 / 6);
        time = new GLabel(model.getInformation(Components.TIME), (double) getWidth() / 2, (double) getHeight() * 4 / 6);
        timer = new GLabel(model.getInformation(Components.TIMER), (double) getWidth() / 2, (double) getHeight() * 5 / 6);
    }

    @Override
    public void addElements() {
        addButtons();
        addLabels();
    }

    private void addButtons() {
        add(clickButton, (double) getWidth() / 3, (double) getHeight() / 2);
    }

    private void addLabels() {
        add(counter, (double) getWidth() / 2, (double) getHeight() * 1 / 6);
        add(keyboardLayout, (double) getWidth() / 2, (double) getHeight() * 2 / 6);
        add(systemVersion, (double) getWidth() / 2, (double) getHeight() * 3 / 6);
        add(time, (double) getWidth() / 2, (double) getHeight() * 4 / 6);
        add(timer, (double) getWidth() / 2, (double) getHeight() * 5 / 6);
    }

}
