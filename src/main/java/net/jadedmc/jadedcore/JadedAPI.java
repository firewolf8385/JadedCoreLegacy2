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

import net.jadedmc.jadedcore.databases.MongoDB;
import net.jadedmc.jadedcore.databases.MySQL;
import net.jadedmc.jadedcore.databases.Redis;
import net.jadedmc.jadedcore.networking.Instance;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * A collection of commonly used utility methods in JadedMC plugins.
 */
public class JadedAPI {
    private static JadedCorePlugin plugin;

    public static MongoDB getMongoDB() {
        return plugin.getMongoDB();
    }

    public static MySQL getMySQL() {
        return plugin.getMySQL();
    }

    public static Redis getRedis() {
        return plugin.getRedis();
    }

    public static Instance getServer(String serverName) {
        return plugin.getInstanceMonitor().getInstance(serverName);
    }

    public static int getServerMajorVersion() {

    }

    public static int getServerMinorVersion() {

    }

    /**
     * Initialize the API.
     * @param pl Instance of the plugin.
     */
    public static void init(JadedCorePlugin pl) {
        plugin = pl;
    }

    /**
     * Sends a player to a given server using the Plugin Messaging Channel.
     * This is to avoid Redis calls whenever possible while still allowing to scale to multiple proxies.
     * @param player Player to change servers.
     * @param server Sever the player is sent to.
     */
    public static void sendPlayerToServer(Player player, String server) {

    }

    /**
     * Sends a player to a given server using Redis.
     * @param uuid UUID of the player to change servers.
     * @param server Server the player is sent to.
     */
    public static void sendPlayerToServer(UUID uuid, String server) {

    }
}