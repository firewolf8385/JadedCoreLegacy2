/*
 * This file is part of JadedCoreLegacy, licensed under the MIT License.
 *
 *  Copyright (c) JadedMC
 *  Copyright (c) contributors
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in all
 *  copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 *  SOFTWARE.
 */
package net.jadedmc.jadedcore.settings;

import net.jadedmc.jadedcore.JadedCorePlugin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Allows easy access to plugin configuration files.
 */
public class SettingsManager {
    private FileConfiguration config;
    private final File configFile;
    private FileConfiguration databases;
    private File databasesFile;
    private FileConfiguration lobby;
    private File lobbyFile;

    /**
     * Creates the SettingsManager and loads each config file.
     * @param plugin Instance of the plugin.
     */
    public SettingsManager(final JadedCorePlugin plugin) {
        // Load config.yml
        config = plugin.getConfig();
        config.options().copyDefaults(true);
        configFile = new File(plugin.getDataFolder(), "config.yml");
        plugin.saveConfig();

        // Load databases.yml
        databasesFile = new File(plugin.getDataFolder(), "databases.yml");
        databases = YamlConfiguration.loadConfiguration(databasesFile);
        if(!databasesFile.exists()) {
            plugin.saveResource("databases.yml", false);
        }

        // Load lobby.yml
        lobbyFile = new File(plugin.getDataFolder(), "lobby.yml");
        lobby = YamlConfiguration.loadConfiguration(lobbyFile);
        if(!lobbyFile.exists()) {
            plugin.saveResource("levels.yml", false);
        }
    }

    /**
     * Get the main configuration file.
     * @return Main configuration file.
     */
    public FileConfiguration getConfig() {
        return config;
    }

    /**
     * Get the databases.yml file.
     * @return Databases configuration file.
     */
    public FileConfiguration getDatabases() {
        return databases;
    }

    /**
     * Get the lobby.yml file.
     * @return Lobby configuration file.
     */
    public FileConfiguration getLobby() {
        return lobby;
    }

    /**
     * Update the config.yml file.
     */
    public void reloadConfig() {
        saveConfig();
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    /**
     * Update the databases.yml file.
     */
    public void reloadDatabases() {
        saveDatabases();
        databases = YamlConfiguration.loadConfiguration(databasesFile);
    }

    /**
     * Update the lobby.yml file.
     */
    public void reloadLobby() {
        saveLobby();
        lobby = YamlConfiguration.loadConfiguration(lobbyFile);
    }

    /**
     * Saves the current config.yml.
     */
    public void saveConfig() {
        try {
            config.save(configFile);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Saves the current databases.yml.
     */
    public void saveDatabases() {
        try {
            databases.save(databasesFile);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    /**
     * Saves the current lobby.yml.
     */
    public void saveLobby() {
        try {
            lobby.save(lobbyFile);
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}