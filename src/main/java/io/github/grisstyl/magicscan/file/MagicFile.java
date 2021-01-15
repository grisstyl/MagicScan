package io.github.grisstyl.magicscan.file;

import io.github.grisstyl.ppapi.file.YamlFile;
import io.github.grisstyl.magicscan.MagicScanController;

import java.io.File;

/**
 * Represents a YAML file from plugins/Magic/
 */
public class MagicFile extends YamlFile {

    public static final String PATH;

    static {
        PATH = "Magic" + File.separator;
    }

    private MagicScanController controller;

    public MagicFile(MagicScanController controller, String fileName) {
        super(controller.getPlugin().getDataFolder().getParentFile(), fileName.startsWith(PATH) ? fileName : PATH + fileName);

        this.controller = controller;
    }
}
