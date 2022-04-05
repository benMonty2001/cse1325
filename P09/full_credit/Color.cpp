#include "Color.h"

#include <string>
#include <sstream>

	Color::Color(int red, int green, int blue) : 
		_red{red}, _green{green}, _blue{blue}{
	}

	std::string Color::to_string() {
		std::ostringstream format;
		format << "(" << _red << "," << _green << "," << _blue << ")";
		return format.str();
	}

	std::string Color::colorize(std::string text) {
		std::ostringstream format;
		format << "\033[38;2;" << _red << ";" << _green << ";" << _blue << "m" << text << "\033[0m";
		return format.str();
	}