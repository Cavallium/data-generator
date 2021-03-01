package it.cavallium.data.generator.nativedata;

import it.cavallium.data.generator.DataSerializer;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;

public class ArraybyteSerializer implements DataSerializer<byte[]> {

	@Override
	public void serialize(DataOutput dataOutput, @NotNull byte[] data) throws IOException {
		dataOutput.writeInt(data.length);
		for (int i = 0; i < data.length; i++) {
			dataOutput.writeByte(data[i]);
		}
	}

	@NotNull
	@Override
	public byte[] deserialize(DataInput dataInput) throws IOException {
		var data = new byte[dataInput.readInt()];
		for (int i = 0; i < data.length; i++) {
			data[i] = dataInput.readByte();
		}
		return data;
	}
}
