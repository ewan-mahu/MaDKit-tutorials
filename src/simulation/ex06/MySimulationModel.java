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
package simulation.ex06;

import madkit.kernel.AbstractAgent;

/**
 * 		#jws simulation.ex06.MySimulationModel jws#
 * 
 *  It is time to display something !!
 *  The only purpose of this class is to show
 *  an example of what could be a launching sequence.
 *  
 *  The display work is done in {@link Viewer}
 *  
 */
public class MySimulationModel extends AbstractAgent{

	// Organizational constants
	public static final String MY_COMMUNITY="simu";
	public static final String SIMU_GROUP="simu";
	public static final String AGENT_ROLE = "agent";
	public static final String ENV_ROLE = "environment";
	public static final String SCH_ROLE	= "scheduler";
	public static final String	VIEWER_ROLE	= "viewer";

	@Override
	protected void activate() {
		// 1 : create the simulation group
		createGroup(MY_COMMUNITY, SIMU_GROUP);

		// 2 : create the environment
		EnvironmentAgent environment = new EnvironmentAgent();
		launchAgent(environment);
		
		// 3 : create the scheduler
		MyScheduler06 scheduler = new MyScheduler06();
		launchAgent(scheduler,true);

		// 3 : create the viewer
		Viewer viewer= new Viewer();
		launchAgent(viewer,true);

		// 2 : launch some simulated agents
		for (int i = 0; i < 10; i++) {
			launchAgent(new SituatedAgent());
		}
	}
	
	public static void main(String[] args) {
		executeThisAgent(1,false); //no gui for me
	}
}
