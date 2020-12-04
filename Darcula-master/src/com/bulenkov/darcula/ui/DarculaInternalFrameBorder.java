/*
 * Copyright 2000-2014 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.bulenkov.darcula.ui;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.InsetsUIResource;
import javax.swing.plaf.UIResource;
import java.awt.*;

/**
 * @author Konstantin Bulenkov
 */
public class DarculaInternalFrameBorder implements Border, UIResource {
    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int w, int h) {
      g.setColor(UIManager.getColor("InternalFrame.darcula.borderColor"));
      g.drawRect(x, y, w-1, h-1);
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new InsetsUIResource(1, 1, 1, 1);
    }

    @Override
    public boolean isBorderOpaque() {
        return true;
    }
}
