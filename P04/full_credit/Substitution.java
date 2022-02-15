class Substitution implements Cypher {
	protected char[] encryptKey = new char[26];
	protected char[] decryptKey = new char[26];
	protected int index(Character target, char[] message){
		return String.valueOf(message).indexOf(target.toString().toLowerCase());
	}
	public Substitution(String key){
		char[] newEncryptKey = key.toLowerCase().toCharArray();
		char[] newDecryptKey = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		boolean goodKey = true;
		if(newEncryptKey.length != 26){
			goodKey = false;
		} else {
			for(int i = 0; i < newEncryptKey.length; i++){
				for(int j = i + 1; j < newEncryptKey.length; j++){
					if(newEncryptKey[i] == newEncryptKey[j]){
						goodKey = false;
						break;
					} else {
						continue;
					}
				}
			}
		}
		if(goodKey){
			this.encryptKey = newEncryptKey;
			this.decryptKey = newDecryptKey;
		}
	}
	public String encrypt(String unencrypted){
		char message[] = unencrypted.toCharArray();
		for(int i = 0; i < message.length; i++){
			if(!Character.isLetter(message[i])){
				continue;
			} else if(Character.isUpperCase(message[i])){
				message[i] = Character.toUpperCase(encryptKey[index(message[i], decryptKey)]);
			} else {
				message[i] = encryptKey[index(message[i], decryptKey)];
			}
		}
		return String.valueOf(message);
	}
	public String decrypt(String encrypted){
		char message[] = encrypted.toCharArray();
		for(int i = 0; i < message.length; i++){
			if(!Character.isLetter(message[i])){
				continue;
			} else if(Character.isUpperCase(message[i])){
				message[i] = Character.toUpperCase(decryptKey[index(message[i], encryptKey)]);
			} else {
				message[i] = decryptKey[index(message[i], encryptKey)];
			}
		}
		return String.valueOf(message);
	}
}