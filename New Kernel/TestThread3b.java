// Simple test class that performs a I/O intensive task to
// to test performance improvement by allowing threads to sleep
// on disk operations. 
import java.util.*

class TestThread3b extends Thread
{
	// Give it a buffer to read/write to
	// Disk.java simulates a slow disk device composed of 1000 blocks,
	// each containing 512 bytes
	private static final WRITE_SIZE = 512;
	private byte[] blocky_boys;
	
	// Basic constructor to initialize the buffer
	public TestThread3b()
	{
		blocky_boys = new byte[WRITE_SIZE];
	}
	
	// Always want a run ¯\_(ツ)_/¯
	public void run()
	{
		SysLib.cout("Testing TestThread3b\n");
		
		for(int i = 0; i < 1000; i++)
		{
			SysLib.rawwrite(i, blocky_boys);
			SysLib.rawread(i, blocky_boys);
		}
		SysLib.exit();
	}
}