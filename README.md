# gr-assignment
# Spustenie Testov pre CMI Calculator

Tento README poskytuje postup na spustenie testov pre aplikáciu CMI Calculator.

## Predpoklady

Pred spustením testov sa uistite, že máte nainštalované a nakonfigurované nasledujúce nástroje:

1. **Android Studio**
   - Stiahnite a nainštalujte Android Studio.
   - Vytvorte Android Virtual Device (AVD) prostredníctvom AVD Managera v Android Studio.

2. **Java Development Kit (JDK)**
   - Stiahnite a nainštalujte JDK verziu 17(s 21 som mal problémy).

3. **Environment Variables**
   - Nastavte systémovú premennú `JAVA_HOME`, aby odkazovala na cestu JDK inštalácie.
   - Nastavte systémovú premennú `ANDROID_HOME`, aby odkazovala na cestu Android SDK. Toto SDK je súčasťou inštalácie Android Studio a obvykle sa nachádza v `C:\Users\<Vaše užívateľské meno>\AppData\Local\Android\Sdk`.

4. **Node.js**
   - Stiahnite a nainštalujte Node.js

5. **Appium**
   - Nainštalujte Appium pomocou npm s príkazom `npm install -g appium` v príkazovom riadku.

## Spustenie Testov

Po dokončení predpokladov môžete pokračovať v spustení testov nasledujúcimi krokmi:

1. **Stiahnite Git Repozitár**
   - Naklonujte alebo stiahnite repozitár s testami z GitHubu.

2. **Spustite Appium Server**
   - Otvorte príkazový riadok alebo terminál a spustite Appium server príkazom `appium`.

3. **Spustenie Testov v IntelliJ IDEA**
   - Otvorte projekt
   - Spustite testy nachádzajúce sa v súbore `CMICalculatorTests.kt`.

