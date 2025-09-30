package com.epicness.fundamentals.automation;

public class AutomationLauncher {

    public static void main(String[] arg) {
        AssetAutomator.automate("Shared", "fundamentals");
        AssetAutomator.automate("Game", "jalcon", "game");
        AssetAutomator.automate("Splash", "jalcon", "splash");
    }
}