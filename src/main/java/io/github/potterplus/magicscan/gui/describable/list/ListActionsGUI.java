package io.github.potterplus.magicscan.gui.describable.list;

import io.github.potterplus.api.string.StringUtilities;
import io.github.potterplus.magicscan.MagicScanController;
import io.github.potterplus.magicscan.gui.describable.ListDescribablesGUI;
import io.github.potterplus.magicscan.magic.spell.SpellAction;
import org.bukkit.entity.HumanEntity;

import java.util.List;
import java.util.Map;

import static io.github.potterplus.api.string.StringUtilities.replaceMap;

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
