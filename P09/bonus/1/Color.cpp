#include "Color.h"

#include <string>
#include <sstream>

	Color::Color(int red, int green, int blue) : 
		_red{red}, _green{green}, _blue{blue}, _reset{false} { }

	Color::Color() : _red{0}, _green{0}, _blue{0}, _reset{true} { }

	std::string Color::to_string() {
		if(!_reset) {
			std::ostringstream format;
			format << "(" << _red << "," << _green << "," << _blue << ")";
			return format.str();
		} else {
			return "(reset)";
		}
	}

	std::string Color::colorize(std::string text) {
		if(!_reset) {
			std::ostringstream format;
			format << "\033[38;2;" << _red << ";" << _green << ";" << _blue << "m" << text << "\033[0m";
			return format.str();
		} else {
			return text;
		}
	}

	std::ostream& operator << (std::ostream& ost, Color color) {
		if(!color._reset) {
			ost << "\033[38;2;" << color._red << ";" << color._green << ";" << color._blue << "m";
			return ost;
		} else {
			ost << "\033[0m";
			return ost;
		}
	}














