#pragma once

#include <string>
#include <sstream>
#include <iostream>

class Color {
	int _red;
	int _green;
	int _blue;
	bool _reset;

	public:

		static const Color RESET;
		static const Color BLACK;
		static const Color BLUE;
		static const Color GREEN;
		static const Color CYAN;
		static const Color RED;
		static const Color MAGENTA;
		static const Color YELLOW;
		static const Color GREY;
		static const Color WHITE;

		Color(int red, int green, int blue); 
		Color();
		
		std::string to_string();

		std::string colorize(std::string text);

		friend std::ostream& operator << (std::ostream& ost, const Color& color);
		friend Color operator + (const Color& color1, const Color& color2);
		friend Color operator + (const Color& color, const int adjust);
		friend Color operator - (const Color& color, const int adjust);
};


