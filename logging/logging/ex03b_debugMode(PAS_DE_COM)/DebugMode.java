/*
 * Copyright 2011-2012 Fabien Michel
 * 
 * This file is part of MaDKit-tutorials.
 * 
 * MaDKit-tutorials is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * MaDKit-tutorials is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MaDKit-tutorials. If not, see <http://www.gnu.org/licenses/>.
 */
package logging.ex03b_debugMode;

import java.util.logging.Level;

import madkit.kernel.Agent;
import madkit.kernel.Madkit;

/**
 * 		
 * 
 * 			#jws logger.ex03b_debugMode.DebugMode jws#
 * 
 * 
 * @author Pascal Wagner
 */

@SuppressWarnings("serial")
public class DebugMode extends Agent {
	
	@Override
	protected void activate() {
		logger.info("Look for the debug mode, activate it and look at the result.");
		logger.info("This option is in the default GUI of the agent.");
	}

	@Override
	protected void live() {
		int i = 10;
		Level l = logger.getLevel();
		while((l != Level.ALL) && (i>=0)){
			pause(1000);
			logger.info("You have "+ i +" seconds");
			l = logger.getLevel();
			i--;
		}
	}

	@Override
	protected void end() {
		Level l = logger.getLevel();
		if (l != Level.ALL){
			logger.info("You are too slow !");
			pause(2000);
		}
		else {
			logger.info("GOOD JOB !\n");
			logger.info("The debug mode permits to display all messages having\n" +
						"            any level of all agents !\n");
			pause(10000);
			launchAgent(new logging.ex03b_debugMode.LaunchAfter(), true);
		}
	}
	
	public static void main(String[] args){
		String[] args2 = { "--launchAgents",
		"logging.ex03b_debugMode.DebugMode,true;" +
		"logging.ex03b_debugMode.LaunchAtTheSameTime,true"};
		Madkit.main(args2);
	}
}