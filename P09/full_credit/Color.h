#pragma once

#include <string>

class Color {
	int _red;
	int _green;
	int _blue;

	public:
		Color(int red, int green, int blue);
		
		std::string to_string();

		std::string colorize(std::string text);
};


