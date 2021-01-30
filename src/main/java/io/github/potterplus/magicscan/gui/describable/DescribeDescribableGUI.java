package io.github.potterplus.magicscan.gui.describable;

import io.github.potterplus.api.gui.GUI;
import io.github.potterplus.api.gui.button.AutoGUIButton;
import io.github.potterplus.api.gui.button.GUIButton;
import io.github.potterplus.magicscan.misc.Describable;
import lombok.Setter;
import org.bukkit.entity.HumanEntity;
import org.bukkit.inventory.ItemStack;

/**
 * TODO Write docs
 */
public class DescribeDescribableGUI extends GUI {

    private Describable describable;
    private HumanEntity human;
    @Setter
    private GUIButton button;

    public DescribeDescribableGUI(String title, Describable describable, HumanEntity human) {
        super(title, 9);

        this.describable = describable;
        this.human = human;

        ItemStack desc = describable.describeAsItem(human);
        final GUIButton def = new AutoGUIButton(desc);

        this.setButton(4, button == null ? def : button);
    }

    public void activate() {
        this.activate(human);
    }
}