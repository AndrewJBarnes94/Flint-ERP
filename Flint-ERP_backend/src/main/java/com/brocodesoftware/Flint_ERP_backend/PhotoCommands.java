package com.brocodesoftware.Flint_ERP_backend;

import javax.imageio.ImageIO;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class PhotoCommands {
	private final PhotoService photoService;
	
	@Autowired
	public PhotoCommands( PhotoService photoService ) {
		this.photoService = photoService;
	}
	
	@ShellMethod( "Show Photo" )
	String showPhoto( String name ) {
		return photoService.download( name ).map( bytes -> {
			try
			{
				var image = ImageIO.read( new ByteArrayInputStream( bytes ) );
				return "Width: " + image.getWidth() + ", Height: " + image.getHeight();
			}
			catch ( IOException e )
 			{
				return "Unable to read image dimensions";
			}
		}).orElse( "Image not found" );
	}
	
}
