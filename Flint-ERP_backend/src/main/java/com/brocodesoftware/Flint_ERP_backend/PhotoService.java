package com.brocodesoftware.Flint_ERP_backend;

import java.io.UncheckedIOException;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PhotoService {
	private final FileSystem fs;
	
	public PhotoService( FileSystem fs ) {
		this.fs = fs;
	}
	
	public Optional<byte[]> download( String name ) {
		try 
		{
			return Optional.of( fs.load(name + ".jpg" ) );
		}
		catch ( UncheckedIOException e ) {
			return Optional.empty(); 
		}
	}
}
