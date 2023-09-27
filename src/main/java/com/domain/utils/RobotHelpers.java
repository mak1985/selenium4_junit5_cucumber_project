package com.domain.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

public class RobotHelpers {
    private Robot robot;
    private static final Logger logger = LogManager.getLogger(AlertHelper.class);

    public RobotHelpers() throws AWTException {
        this.robot = new Robot();
    }

    public void click() {
        // Simulate a left mouse button click.
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void rightClick() {
        // Simulate a right mouse button click (context-click).
        robot.mousePress(InputEvent.BUTTON3_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON3_DOWN_MASK);
    }

    public void doubleClick() {
        // Simulate a double-click.
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    public void keyType(int keyCode) {
        // Simulate typing a key by key code.
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }

    public void typeText(String text) {
        // Simulate typing a string of text.
        for (char c : text.toCharArray()) {
            int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
            robot.keyPress(keyCode);
            robot.keyRelease(keyCode);
        }
    }

    public void moveMouse(int x, int y) {
        // Move the mouse cursor to the specified coordinates.
        robot.mouseMove(x, y);
    }

    public void dragAndDrop(int startX, int startY, int endX, int endY) {
        // Simulate a drag-and-drop operation.
        moveMouse(startX, startY);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        moveMouse(endX, endY);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }
}
