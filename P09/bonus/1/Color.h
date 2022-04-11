#pragma once

#include <string>
#include <iostream>

class Color {
	int _red;
	int _green;
	int _blue;
	bool _reset;

	public:
		Color(int red, int green, int blue); 
		Color();
		
		std::string to_string();

		std::string colorize(std::string text);

		friend std::ostream& operator << (std::ostream& ost, const Color& color);
};


