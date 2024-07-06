package org.scapesoft.api.event.command.impl;

import org.scapesoft.api.event.command.CommandSkeleton;
import org.scapesoft.game.player.Player;
import org.scapesoft.game.player.dialogues.DialogueHandler;
import org.scapesoft.utilities.game.player.Rights;

/**
 * @author Tyluur <itstyluur@gmail.com>
 * @since Mar 22, 2014
 */
public class ReloadDialogues extends CommandSkeleton {

	@Override
	public Rights getRightsRequired() {
		return Rights.OWNER;
	}

	@Override
	public String[] getCommandApplicable() {
		return new String[] { "rld" };
	}

	@Override
	public void execute(Player player) {
		DialogueHandler.reload();
	}

}
