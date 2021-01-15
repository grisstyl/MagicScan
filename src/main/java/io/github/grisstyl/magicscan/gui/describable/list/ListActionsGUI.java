package io.github.grisstyl.magicscan.gui.describable.list;

import io.github.grisstyl.ppapi.misc.StringUtilities;
import io.github.grisstyl.magicscan.MagicScanController;
import io.github.grisstyl.magicscan.gui.describable.ListDescribablesGUI;
import io.github.grisstyl.magicscan.magic.spell.SpellAction;
import org.bukkit.entity.HumanEntity;

import java.util.List;
import java.util.Map;

import static io.github.grisstyl.ppapi.misc.StringUtilities.replaceMap;

/**
 * A simple paginated GUI listing available Magic actions.
 */
public class ListActionsGUI extends ListDescribablesGUI {

    public ListActionsGUI(HumanEntity target, MagicScanController controller) {
        super("Actions", target, controller);
    }

    void refreshToolbar() {

    }

    void refreshEntries() {
        MagicScanController controller = this.getController();
        List<SpellAction> actions = controller.getActions();

        actions.forEach(this::populate);

        boolean empty = getInventory().getItem(0) == null;
        Map<String, String> countReplaceMap = StringUtilities.replaceMap("$count", empty ? "&cNONE" : String.valueOf(getItems().size()));

        this.setTitle(controller.getMessage("gui.list_actions.title", countReplaceMap));
    }

    @Override
    public void initialize() {
        this.refreshToolbar();
        this.refreshEntries();
    }
}
