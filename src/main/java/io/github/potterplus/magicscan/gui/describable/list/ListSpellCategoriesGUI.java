package io.github.potterplus.magicscan.gui.describable.list;

import io.github.potterplus.api.gui.button.GUIButton;
import io.github.potterplus.api.string.StringUtilities;
import io.github.potterplus.magicscan.MagicScanController;
import io.github.potterplus.magicscan.gui.describable.ListDescribablesGUI;
import io.github.potterplus.magicscan.magic.spell.SpellCategory;
import org.bukkit.entity.HumanEntity;

import java.util.List;

import static io.github.potterplus.api.string.StringUtilities.replaceMap;

/**
 * A GUI listing all of the spell categories.
 */
public class ListSpellCategoriesGUI extends ListDescribablesGUI {

    public ListSpellCategoriesGUI(HumanEntity target, MagicScanController controller) {
        super("Spell Categories", target, controller);
    }

    @Override
    public void initialize() {
        MagicScanController controller = getController();
        List<SpellCategory> cats = controller.getSpellCategories();

        for (SpellCategory cat : cats) {
            GUIButton button = new GUIButton(cat.describeAsItem(getTarget()));

            button.setListener(event -> {
                event.setCancelled(true);

                ListSpellsGUI gui = new ListSpellsGUI(getTarget(), getController(), cat.getKey());

                gui.update(event);
                gui.activate();
            });

            this.addButton(button);
        }

        this.setTitle(controller.getMessage("gui.list_spell_categories.title", StringUtilities.replaceMap("$count", String.valueOf(getItems().size()))));
    }
}
