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
package net.jadedmc.jadedcore;

import net.jadedmc.jadedcore.networking.InstanceMonitor;
import net.jadedmc.jadedcore.settings.HookManager;
import net.jadedmc.jadedcore.settings.SettingsManager;
import org.bukkit.plugin.java.JavaPlugin;

public class JadedCorePlugin extends JavaPlugin {
    private HookManager hookManager;
    private InstanceMonitor instanceMonitor;
    private SettingsManager settingsManager;

    /**
     * Runs when the plugin is enabled.
     */
    @Override
    public void onEnable() {
        settingsManager = new SettingsManager(this);
        hookManager = new HookManager(this);
        instanceMonitor = new InstanceMonitor();
    }

    /**
     * Runs when the plugin is disabled.
     */
    @Override
    public void onDisable() {
        // TODO: Delete Instance cache from Redis
    }

    /**
     * Get the HookManager.
     * @return Hook Manager.
     */
    public HookManager getHookManager() {
        return hookManager;
    }

    /**
     * Get the InstanceMonitor.
     * @return Instance Monitor.
     */
    public InstanceMonitor getInstanceMonitor() {
        return instanceMonitor;
    }

    /**
     * Get the SettingsManager.
     * @return Settings Manager.
     */
    public SettingsManager getSettingsManager() {
        return settingsManager;
    }
}
